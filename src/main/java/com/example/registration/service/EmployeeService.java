package com.example.registration.service;

import com.example.registration.model.Employee;
import com.example.registration.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> listAllEmployee() {
        return employeeRepository.findAll();
    }

    public void saveUser(Employee emp) {
    	employeeRepository.save(emp);
    }

    public Employee getUser(Integer id) {
		Optional<Employee> emp =employeeRepository.findById(id);
		return emp.orElse(null);
    }
    
    public List<Employee> getUserByName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }

    public void deleteUser(Integer id) {
    	employeeRepository.deleteById(id);
    }
}
