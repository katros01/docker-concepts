package com.gtp2.devOpsConcepts.docker.service;


import com.gtp2.devOpsConcepts.docker.model.Employee;
import com.gtp2.devOpsConcepts.docker.exception.EmployeeNotFoundException;
import com.gtp2.devOpsConcepts.docker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Cacheable(value = "employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Cacheable(value = "employee", key = "#id")
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void addEmployee(Employee employee) {
         employeeRepository.save(employee);
    }

}