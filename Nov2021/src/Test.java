import java.util.Arrays;
import java.util.Collections;

public class Test {

	
	
	
	
	
		
		
	

	public static void main(String[] args) {
		String all_vals  = "1,2,3,4,5";
		String check_val= "6,7";
		
		String allValArr[] = all_vals.split(",");
		String checkValArr[] = check_val.split(",");
		
		    System.out.println(!Collections.disjoint(Arrays.asList(allValArr), Arrays.asList(checkValArr)));
		 }

	

}
