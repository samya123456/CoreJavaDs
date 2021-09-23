package com.example.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;





public class StreamAPIEx {
	
	public static class EmployeeEx {
		
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

		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
	
	
	/*list.stream()
		.collect(Collectors.groupingBy(EmployeeEx :: getName, Collectors.counting()))
		.entrySet()
		.stream()
		.filter(m->m.getValue()>1)
		.map(Map.Entry::getKey)
		.forEach(System.out::println);*/
	
	list.stream()
	    .filter(e->e.getName()=="Samya" ||e.getName()=="Sujoy")
	    .map(EmployeeEx::getSalary)
	    .collect(Collectors.toList());
			
			

	}

}
