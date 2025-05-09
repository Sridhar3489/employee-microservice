package com.microservice.employee_service.controller;

import com.microservice.employee_service.model.Employee;
import com.microservice.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("Adding employee: " + employee);
        return employeeRepository.save(employee);
    }

    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        log.info("Getting all employees");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Getting employee with id: " + id);
        return employeeRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        log.info("Deleting employee with id: " + id);
        employeeRepository.deleteById(id);
    }

    @GetMapping("/dep/{id}")
    public List<Employee> findByDepartment(@PathVariable Long id){
        log.info("Getting employees by department id: " + id);
        return employeeRepository.findByDepartmentId(id);
    }


}
