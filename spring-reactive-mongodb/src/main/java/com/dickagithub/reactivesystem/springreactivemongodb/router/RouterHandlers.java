package com.dickagithub.reactivesystem.springreactivemongodb.router;

import com.dickagithub.reactivesystem.springreactivemongodb.model.Employee;
import com.dickagithub.reactivesystem.springreactivemongodb.model.EmployeeEvent;
import com.dickagithub.reactivesystem.springreactivemongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@Component
public class RouterHandlers {

    @Autowired
    private EmployeeRepository employeeRepository;

    //router find all
    public Mono<ServerResponse> getAll(ServerRequest serverRequest){
        return ServerResponse.ok()
                .body(employeeRepository.findAll(), Employee.class);
    }

    //router find by id
    public Mono<ServerResponse> getOne(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return ServerResponse.ok()
                .body(employeeRepository.findById(id), Employee.class);
    }

    //router find by id and action events
    public Mono<ServerResponse> getEvents(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(
                        employeeRepository.findById(id)
                        .flatMapMany(employee -> {
                            Flux<Long> IntervalDuration = Flux.interval(Duration.ofSeconds(2));

                            Flux<EmployeeEvent> employeeEventFlux =
                                    Flux.fromStream(Stream.generate(()->
                                    new EmployeeEvent(employee, new Date())));

                            return Flux.zip(IntervalDuration, employeeEventFlux)
                                    .map(Tuple2::getT2);
                        }), EmployeeEvent.class
                );
    }
}
