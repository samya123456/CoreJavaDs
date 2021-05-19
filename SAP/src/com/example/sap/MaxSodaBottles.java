package com.example.sap;

import java.util.Scanner;

public class MaxSodaBottles {
	
	
	private static int soda_count = 0;
	private static int residual = 0;

	
	public static void buySoda(int money ,int extraFound , int SODA_PRICE) {
		soda_count = (money+extraFound) / SODA_PRICE;
		exchangeSoda(soda_count,SODA_PRICE);
	}
 
	private static void exchangeSoda(int bottleCount,int SODA_PRICE) {
		 
		if (bottleCount <= 1) {
			return;
		} else {
			
			int temp1 = bottleCount / SODA_PRICE;
			soda_count += temp1;
			 
			int temp2 = bottleCount % SODA_PRICE;
			 
			residual += temp2;
			 
			if (temp1 <= 1) {
				
				temp1 += residual;
				 
				residual = 0;
			}
			exchangeSoda(temp1,SODA_PRICE);
		}
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a=0;
		int b=0;
		int c=0;
		while (sc.hasNextInt()) {
             a = sc.nextInt();
             b = sc.nextInt();
             c = sc.nextInt();
            System.out.println(Math.abs(a-b));
        }
		buySoda(a,b,c);
		System.out.println(soda_count);

	}

}
