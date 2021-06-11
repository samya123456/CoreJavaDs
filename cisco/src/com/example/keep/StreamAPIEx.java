package com.example.keep;
import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIEx {
	
	

	public static void main(String[] args) {
		EmployeeEx e1 = new EmployeeEx("Samya" , 1500);
		EmployeeEx e2 = new EmployeeEx("Samya" , 5000);
		EmployeeEx e3 = new EmployeeEx("Sujoy" , 13000);
		EmployeeEx e4 = new EmployeeEx("Nishant" , 3000);
		EmployeeEx e5 = new EmployeeEx("Arghya" , 2000);
		EmployeeEx e6 = new EmployeeEx("Samya" , 7000);
		EmployeeEx e7 = new EmployeeEx("Sabba" , 8000);
		EmployeeEx e8 = new EmployeeEx("Sujoy" , 100000);
		
		
		List<EmployeeEx> list = new ArrayList<EmployeeEx>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		
	String a=	list
		.stream()
		.sorted(Comparator.comparingInt(EmployeeEx::getSalary).reversed())
		.findFirst()
		.map(EmployeeEx::getName)
		.get();
	
	//System.out.println(a);
							list
							.parallelStream()
							.filter(employee -> employee.getSalary()>3000)
							.map(EmployeeEx::getName)
							.collect(Collectors.toList());
							//.forEach(System.out::println);
							
							
							
					list
					.stream()
					.collect(Collectors.groupingBy(EmployeeEx::getName,
							Collectors.counting()))
					.entrySet()
					.stream()
					.filter(m ->m.getValue()>1)
					.map(Map.Entry::getKey)
					.collect(Collectors.toSet())
					
					.forEach(System.out::println);
					
					
					
					
					
				
				            
							
							
						
							
							

	}

}
