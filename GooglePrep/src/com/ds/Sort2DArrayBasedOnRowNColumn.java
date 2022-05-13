package com.ds;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DArrayBasedOnRowNColumn {

	public static void sort2DArrayBasedOnColumnNumber(int[][] multi, int columnNumber) {

		Arrays.sort(multi, new Comparator<int[]>() {

			@Override
			public int compare(int[] firstColumn, int[] secondColumn) {

				if(firstColumn[columnNumber-1] > secondColumn[columnNumber-1]) {
					return 1;
				}
				return -1;
			}

		});

	}
	
	public static void sort2DArrayBasedOnRow(int[][] multi) {
		for(int i =0;i<multi.length;i++) {
			Arrays.sort(multi[i]);
		}
	}

	public static void main(String[] args) {
		int[][] multi = new int [][]{
            {4, 9, 8},
            {7, 5, 2},
            {3, 0, 6},};
            
            for(int i = 0; i< multi.length; i++) {
                for (int j = 0; j < multi[i].length; j++)
                    System.out.print(multi[i][j] + " ");
                    System.out.println();

            }
            
            sort2DArrayBasedOnColumnNumber(multi,3);
            System.out.println("after sorting");
            for(int i = 0; i< multi.length; i++) {
                for (int j = 0; j < multi[i].length; j++)
                    System.out.print(multi[i][j] + " ");
                    System.out.println();

            }

	}

}
