package com.example.dp;

import java.util.HashSet;
import java.util.Set;

public class SingleTonSubClass {
	
	
	public static class Parent{
		
		static Set<Object> set = new HashSet<>();
		public Parent() throws Exception {
			if(set.contains(this.getClass())) {
				throw new Exception();
			}
			set.add(this.getClass());
		}
	}
	
	public static class Child extends Parent{

		public Child() throws Exception {
			
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Child c1 = new Child();
		Child c2 = new Child();

	}

}
