package com.adp;

public class Employee {
	
	public String workerId;
	public Integer salary;
	public String firstName;
	
	public Employee(String workerId, int salary,String firstName) {
		this.firstName = firstName;
		this.salary = salary;
		this.workerId = workerId;
	}

	
	


	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String enployeeDetails) {
		this.workerId = enployeeDetails;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
