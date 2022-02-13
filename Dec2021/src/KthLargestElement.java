import java.util.PriorityQueue;

public class KthLargestElement {
	
   public static int	kthElement(int[] arr,int k) {
	   PriorityQueue<Integer> queue = new  PriorityQueue<Integer>();
	   
	   for(int i=0;i<arr.length;i++) {
		   queue.add(arr[i]);
		   if(queue.size()>k) {
			   queue.remove();
		   }
	   }
	   return queue.remove();
   }

	public static void main(String[] args) {
			
		
		int arr[] = {10,2,30,7,8};
         System.out.println(kthElement(arr,1));

	}

}
