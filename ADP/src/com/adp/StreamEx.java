package com.adp;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEx {

	public static void main(String[] args) {
		int arr[] = {4,4,6,57,100,1,2,0,25};
		
	/*int sum=	IntStream.of(arr)
		.sorted()
		.distinct()
		.limit(3)
		.sum();
	System.out.println(sum);*/
		
		Employee e1 = new Employee("123",10, "Samya");
		Employee e2 = new Employee("123",40, "Ravi");
		Employee e3 = new Employee("123",30, "Gagan");
		Employee e4 = new Employee("123",20, "Pankaj");
		Employee e5 = new Employee("123",100, "Uday");
		Employee e6 = new Employee("123",19, "nandy");
		Employee e7 = new Employee("123",112, "Amit");
		Employee e8 = new Employee("123",1000, "Deepak");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
		employeeList.add(e6);
		employeeList.add(e7);
		employeeList.add(e8);
		
		List<String> names =
		employeeList.stream()
		.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
		.limit(3)
		.map(Employee::getFirstName)
		.collect(Collectors.toList());
		
		names.stream().forEach(System.out::println);

	}

}
