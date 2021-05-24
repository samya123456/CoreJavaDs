package com.pega;
import java.util.NoSuchElementException;

public class CustomIteratorFor2DArray{

	int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
	private int currentRow = 0;
    private int currentColumn = 0;
	
	public boolean hasNext() {
		if(currentRow+1 ==arr.length) {
			return currentColumn<arr[currentRow].length;
		}
		return currentRow<arr.length;
		
	}
	
	public Integer next() {
		if(currentColumn == arr[currentRow].length) {
			currentColumn =0;
			currentRow++;
		}
		
		if(currentColumn== arr[currentRow].length-1 && currentRow==arr.length-1) {
			
			int temp= arr[currentRow][currentColumn];
			currentColumn++;
			return temp;
		}
		return arr[currentRow][currentColumn++];
	}
	
	
	public static void main(String[] args) {
		
		CustomIteratorFor2DArray customIteratorFor2DArray = new CustomIteratorFor2DArray();
		
		while(customIteratorFor2DArray.hasNext()) {
			System.out.println(customIteratorFor2DArray.next());
		}
		

	}

}
