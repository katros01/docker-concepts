package com.gtp2.devOpsConcepts.docker.repository;

import com.gtp2.devOpsConcepts.docker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
