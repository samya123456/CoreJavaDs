import java.util.*;

public class ZigzagConversion {
	
	 public static String convert(String s, int numRows) {
	        Map<Integer,List<Character>> map = new LinkedHashMap<>();
	        boolean isUp=false;
	        int counter=1;
	        for(int i=0;i<s.length();i++){
	            char ch =s.charAt(i);
	            
	          
	            
	           
	            if(map.containsKey(counter)){
	                List<Character> tempList = map.get(counter);
	                tempList.add(ch);
	                map.put(counter,tempList);
	            }else{
	                List<Character> list = new ArrayList<Character>();
	                list.add(ch);
	                map.put(counter,list);
	            }
	            
	            if(!isUp){
	                counter++;
	            }else{
	                counter--;
	            }
	            if(counter==numRows){
	                isUp=true;
	                
	            }else if(counter==1){
	                isUp=false;
	               
	            }
	        }
	        StringBuilder br = new StringBuilder();
	        for(Map.Entry<Integer,List<Character>> entry:map.entrySet()){
	             List<Character> list = entry.getValue();
	            for(int i=0;i<list.size();i++){
	                br.append(list.get(i));
	            }
	        }
	        
	        return br.toString();
	        
	        
	        
	    }

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",3));

	}

}
