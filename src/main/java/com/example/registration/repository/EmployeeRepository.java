package com.example.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByEmployeeName(String employeeName);
}
