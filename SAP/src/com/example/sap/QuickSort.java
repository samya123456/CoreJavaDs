package com.example.sap;

public class QuickSort {
	
	public static int[] numbers;
	public int size;
	
	public void sort(int[] values) {
		
		if (values.length==0 || values.length==1) {
			return;
		}
		this.numbers = values;
		this.size= values.length;
		
		quickSort(0,size-1);
		
	}
	
	

	private void quickSort(int low, int high) {
		
		int i = low;
		int j = high;
		int pivot = numbers[low + ((high-low)/2)];
		while(i<=j) {
			
			while(numbers[i]<pivot) {
				i++;
			}
			
			while(numbers[j]>pivot) {
				j--;
			}
			
			if(i<=j) {
				swap(i,j);
				i++;
				j--;
			}
			
		}
		
		if(low<j) {
			quickSort(low,j);
		}
		
		if(i<high) {
			quickSort(i,high);
		}
		
		
	}



	private void swap(int i, int j) {
		int temp =numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		
		
	}



	public static void main(String[] args) {
		int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
		
	    new QuickSort().sort(test);
	    
	    
	    for(int i=0;i<test.length;i++)
	    System.out.println(numbers[i]);
	    

	}

}
