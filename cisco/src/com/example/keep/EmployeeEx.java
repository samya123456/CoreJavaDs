package com.example.keep;

public class EmployeeEx {
	
	private String name;
	private Integer salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public EmployeeEx(String name, Integer salary){
		this.name = name;
		this.salary = salary;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
