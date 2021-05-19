package payPal;

import java.util.HashMap;
import java.util.Map;

public class A {
	static Map<String,Object> mp = new HashMap<String,Object>();
	A() throws Exception{
		if(mp.containsKey(this.getClass().getName())) {
			throw new Exception("BYE........");
		}
		mp.put(this.getClass().getName(), this.getClass());
		
		System.out.println("Class name" + this.getClass());
	}

	
}
