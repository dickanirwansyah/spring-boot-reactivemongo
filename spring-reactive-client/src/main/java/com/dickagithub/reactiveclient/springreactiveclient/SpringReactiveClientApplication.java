package com.dickagithub.reactiveclient.springreactiveclient;

import com.dickagithub.reactiveclient.springreactiveclient.model.Employee;
import com.dickagithub.reactiveclient.springreactiveclient.model.EmployeeEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringReactiveClientApplication {

	//web client
	@Bean
	WebClient webClient(){
		return WebClient.create("http://localhost:8081/resources/");
	}

	//test dengan command line runner
	@Bean
	CommandLineRunner commandLineRunner(WebClient client){
		return args -> {

			client.get()
					.uri("/employees")
					.retrieve()
					.bodyToFlux(Employee.class)
					.filter(employee -> employee.getName().equals("Muhammad Dicka Nirwansyah"))
					.flatMap(employee -> {

						return client.get()
								.uri("/employees/{id}/events", employee.getId())
								.retrieve()
								.bodyToFlux(EmployeeEvent.class);

					}).subscribe(System.out::println);

			//blocking
			for (int i=0; i< 1000; i++){
				System.out.println("Blocking 1");
				Thread.sleep(1000);
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveClientApplication.class, args);
	}
}
