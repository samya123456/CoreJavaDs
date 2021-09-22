package google.com;

import java.util.*;

public class ZigZagConversion {
	 public static String convert(String s, int numRows) {
	        Map<Integer,StringBuffer> map = new LinkedHashMap<Integer,StringBuffer>();
	        int rem =0;
	        boolean down =true;
	        for(int i=0;i<s.length();i++){
	        	if(rem==numRows) {
	        		down=false;
	        	}
	        	
	        	if(rem==1) {
	        		down =true;
	        	}
	        	
	        	if(down) {
	        		rem++;
	        	}else {
	        		rem--;
	        	}
	        	 
	            if(map.containsKey(rem)){
	                StringBuffer br = map.get(rem);
	                br.append(s.charAt(i));
	                map.put(rem,br);
	            }else{
	                StringBuffer br1 = new StringBuffer(Character.toString(s.charAt(i)));
	                map.put(rem,br1);
	            }
	            
	           
	            
	           
	           
	            
	        }
	        
	         Set<Map.Entry<Integer,StringBuffer>> set = map.entrySet();
	         StringBuffer output = new StringBuffer("");
	        for(Map.Entry<Integer,StringBuffer> entry : set){
	            output.append(entry.getValue());
	        }
	        
	        return output.toString();
	        
	        
	    }
	 
	

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",3));

	}

}
