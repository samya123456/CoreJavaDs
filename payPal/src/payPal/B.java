package payPal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B extends A {
	
	B()throws Exception{
	}
	
	
	public static void main(String[] a ) throws Exception {
		
		
		ArrayList<String> l = new ArrayList<String>();
		
		l.add("1");
		l.add("2");
		l.add("3");
		System.out.println(l.remove("3"));
		
	}
}
