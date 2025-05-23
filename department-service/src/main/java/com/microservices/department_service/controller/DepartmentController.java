package com.microservices.department_service.controller;

import com.microservices.department_service.client.EmployeeClient;
import com.microservices.department_service.model.Department;
import com.microservices.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    EmployeeClient employeeClient;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        log.info("Department information: " + department);
        return departmentRepository.save(department);
    }

    @GetMapping
    public Iterable<Department> getAllDepartments() {
        log.info("Getting all departments");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        log.info("Getting department with id: " + id);
        return departmentRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Long id) {
        log.info("Deleting department with id: " + id);
        departmentRepository.deleteById(id);
    }

    @GetMapping("/employees")
    public List<Department> getAllDepartmentsWithEmployees() {
        List<Department> departments = departmentRepository.findAll();
                departments.forEach(
                        department -> {
                            department.setEmployees(employeeClient.getEmployeesByDepartmentId(department.getId()));
                        }
        );
        return departments;
    }

}
