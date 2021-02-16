package com.example.basicCRUD.controllers.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeID;
	private String employeeName;
	private String employeeAge;
	private String employeeGender;


	public Employee(){

	}

	public Employee(String employeeName, String employeeAge, String employeeGender){
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeGender = employeeGender;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}
}
