package google.com;

import java.util.PriorityQueue;

public class SortedSquaredArray {
	
	

	public static void main(String[] args) {
		PriorityQueue<Double> pq = new PriorityQueue<Double>();
		int[] input = {-7,-3,-1,3,4,8,12};
		for(int i =0 ;i<input.length;i++) {
			pq.add(Math.pow(input[i], 2));
		}
		
		for(Double d:pq) {
			System.out.println(d);
		}

	}

}
