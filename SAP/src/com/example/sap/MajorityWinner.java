package com.example.sap;

import java.util.Scanner;

public class MajorityWinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numOfTestCases=sc.nextInt();
		for(int i=0;i<numOfTestCases;i++) {
			int numOfcandidates =sc.nextInt();
			
			int maxVote =sc.nextInt();
			int maxIndex =1;
			int vote = maxVote;
			int totalVote =vote;
			boolean equalVote=true;
			for(int j=2;j<=numOfcandidates;j++) {
				int temp =sc.nextInt();
				if(equalVote && vote==temp) {
					equalVote=true;
					
				}else {
					equalVote=false;
				}
				vote =temp ;
				totalVote = totalVote + vote;
				if(vote>maxVote) {
					maxVote=vote;
					maxIndex=j;
				}
			}
			if(equalVote) {
				System.out.println("no winner");
			}
			else if(totalVote/2 <maxVote) {
				System.out.println("majority winner "+maxIndex);
			}else if(totalVote/2 >=maxVote) {
				System.out.println("minority winner "+maxIndex);
			}
		}

	}

}
