package google.com;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DArrayBasedonRowOrColumn {
	
	public static void Sort2DArrayBasedOnColumnNumber(int[][] arr ,int columnNumber) {
		Arrays.sort(arr,new Comparator<int[]>(){
			
			@Override
			public int compare(int[] first,int[]second) {
				if(first[columnNumber-1] >second[columnNumber-1]) {
					return 1;
				}else {
					return -1;
				}
			}
		});
	}
	
	public static void sortRowWise(int arr[][],int rowNumber) {
		Arrays.sort(arr[rowNumber-1]);
	}

	public static void main(String[] args) {
		 int[][] arr = new int [][]{
             {4, 9, 8},
             {7, 5, 2},
             {3, 0, 6},

     };
     
     
     int time[][] = {{ 900, 890, 950, 1100, 1500, 1800 },
     				 { 910, 1200, 1120, 1130, 1900, 2000 }};
     
     for(int i = 0; i< arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++)
             System.out.print(arr[i][j] + " ");
             System.out.println();

     }
     Sort2DArrayBasedOnColumnNumber(arr,1);
     System.out.println("---------------------");
     
     for(int i = 0; i< arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++)
             System.out.print(arr[i][j] + " ");
             System.out.println();

     }

	}

}
