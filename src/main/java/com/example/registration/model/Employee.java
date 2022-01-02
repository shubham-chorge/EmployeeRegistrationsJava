package com.example.registration.model;

import java.sql.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
	
    public Employee(int employeeNo, String employeeName, Date date_of_joining, String department, float salary) {
		super();
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.date_of_joining = date_of_joining;
		this.department = department;
		this.salary = salary;
	}

    @Id
    @Column(name = "employee_no")
	private int employeeNo;
    @Column(name = "employee_name")
    private String employeeName;
    private Date date_of_joining;
    private String department;
    private float salary;

    public Employee() {
    }

		
}
