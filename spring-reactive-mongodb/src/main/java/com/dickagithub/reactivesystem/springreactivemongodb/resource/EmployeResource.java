package com.dickagithub.reactivesystem.springreactivemongodb.resource;

/*
import com.dickagithub.reactivesystem.springreactivemongodb.model.Employee;
import com.dickagithub.reactivesystem.springreactivemongodb.model.EmployeeEvent;
import com.dickagithub.reactivesystem.springreactivemongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/resources")
public class EmployeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/employees")
    public Flux<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping(value = "/employees/{id}")
    public Mono<Employee> getOne(@PathVariable(value = "id") final String id){
        return employeeRepository.findById(id);
    }

    @GetMapping(value = "/employees/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeEvent> getOneEvents(@PathVariable(value = "id") final String id){
       return employeeRepository.findById(id)
                .flatMapMany(employee -> {

                    //Flux getT1
                    Flux<Long> IntervalDuration = Flux.interval(Duration.ofSeconds(2));
                    //Flux getT2
                    Flux<EmployeeEvent> employeeEventFlux = Flux.fromStream(
                            Stream.generate(() -> new EmployeeEvent(employee, new Date()))
                    );

                    return Flux.zip(IntervalDuration, employeeEventFlux)
                            .map(Tuple2::getT2);
                });
    }

}
*/