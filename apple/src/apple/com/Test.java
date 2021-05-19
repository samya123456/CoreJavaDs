package apple.com;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		PriorityQueue <Integer> queue=new PriorityQueue <Integer>();  
		
		Integer arr[] = {4, 3, 2, 6};
		for(int i=0;i<arr.length;i++) {
			queue.add(arr[i]);
		}
	
       int sum =0;
		while(!queue.isEmpty()) {
			int a = queue.poll();
			int b =0;
			if(!queue.isEmpty()){
				 b = queue.poll();	
				 queue.add(a+b);
				 sum = sum + a+b;
			}
			
			
		}
		
		
		System.out.println(sum);
		
		
	}

}
