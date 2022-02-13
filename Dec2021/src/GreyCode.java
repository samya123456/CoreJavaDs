import java.util.ArrayList;
import java.util.List;

public class GreyCode {
	public static List<Integer> printGrey(int n) {
		List<Integer> list = new ArrayList<Integer>();
	       for(int i =0;i< 1<<n ;i++){
	           list.add( i ^ (i>>1));
	       }
	        
	        return list;
	}
	

	public static void main(String[] args) {
		System.out.println(printGrey(2));;

	}

}
