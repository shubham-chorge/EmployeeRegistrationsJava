package com.example.registration.controller;

import com.example.registration.model.Employee;
import com.example.registration.service.EmployeeService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("")
	public List<Employee> list() {
		System.out.println("inside");
		return employeeService.listAllEmployee();
	}

	@GetMapping("/getByNo/{employeeNo}")
	public String get(@PathVariable Integer employeeNo) {
		Employee emp = null;
		if (employeeNo != null) {
			emp = employeeService.getUser(employeeNo);
			if (emp == null)
				return "No records found";
			Gson gson = new Gson();
			String json = gson.toJson(emp);
			return json;
		} else {
			return "Invalid Employee Number";
		}

	}

	@GetMapping("/getByName/{employeeName}")
	public String get(@PathVariable String employeeName) {
		if (!employeeName.trim().isEmpty()) {
			List<Employee> empList = employeeService.getUserByName(employeeName);
			if (empList.size() == 0)
				return "No records found";

			Gson gson = new Gson();
			String json = gson.toJson(empList);
			return json;
		} else {
			return "Invalid Employee Name";
		}
	}

	@PostMapping("/addemployee")
	public ResponseEntity<String> add(@RequestBody Employee emp) {
		System.out.println("inside post");
		try {

			employeeService.saveUser(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request Parameters");
		}
	}

	@DeleteMapping("/{employee_no}")
	public void delete(@PathVariable Integer employee_no) {

		employeeService.deleteUser(employee_no);
	}
}
