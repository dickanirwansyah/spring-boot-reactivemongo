package com.dickagithub.reactivesystem.springreactivemongodb.repository;

import com.dickagithub.reactivesystem.springreactivemongodb.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>{
}
