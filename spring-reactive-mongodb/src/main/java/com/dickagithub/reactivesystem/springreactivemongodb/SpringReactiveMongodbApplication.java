package com.dickagithub.reactivesystem.springreactivemongodb;

import com.dickagithub.reactivesystem.springreactivemongodb.model.Employee;
import com.dickagithub.reactivesystem.springreactivemongodb.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringReactiveMongodbApplication {

	//test with command line runner
	@Bean
	public CommandLineRunner emmployees(EmployeeRepository employeeRepository){
		return args -> {
			employeeRepository
					.deleteAll()
					.subscribe(null, null, ()-> {

						Stream.of(new Employee(UUID.randomUUID().toString(),
								"Muhammad Dicka Nirwansyah", 150000L),
								new Employee(UUID.randomUUID().toString(),
										"Sinthya", 70000L),
								new Employee(UUID.randomUUID().toString(),
										"Alvina Mumtaza Yusuf", 50000L),
								new Employee(UUID.randomUUID().toString(),
										"Sita", 75000L),
								new Employee(UUID.randomUUID().toString(),
										"Sendy Firdaus", 9000L),
								new Employee(UUID.randomUUID().toString(),
										"Eva Luthfia", 110000L),
								new Employee(UUID.randomUUID().toString(),
										"Ahmad Luthfi Yahyha", 90000L))
								.forEach(employee -> {
									employeeRepository.save(employee)
											.subscribe(System.out::println);
								});
					});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveMongodbApplication.class, args);
	}
}
