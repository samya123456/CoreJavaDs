package com.example;

import java.util.Map;
import java.util.stream.Collectors;


public interface I {

	default  void doJob() {

		System.out.print("I");
	}

}


/*list
.stream()
.collect(
	    Collectors.groupingBy(EmployeeEx::getName, 
	    Collectors.counting()))
.entrySet()
.stream()
.filter(m -> m.getValue() > 1)
.map(Map.Entry::getKey)
.collect(Collectors.toSet())
.forEach(System.out::println);
*/