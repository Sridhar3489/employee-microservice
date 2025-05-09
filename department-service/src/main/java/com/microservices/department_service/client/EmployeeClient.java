package com.microservices.department_service.client;

import com.microservices.department_service.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
//this interface cannot be accessed directly
//so we use WebClient
public interface EmployeeClient {

    @GetExchange("/employees/dep/{id}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Long id);

}
