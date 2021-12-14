package com.example.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.react.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
