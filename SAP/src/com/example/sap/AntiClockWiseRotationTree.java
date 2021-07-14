package com.example.sap;





public class AntiClockWiseRotationTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	
	public void printLeftToRight(Node root,int level) {
		if(root==null) {
			return;
		}
		if(level==1) {
			System.out.println(root.data);
		}else if(level>1) {
			printLeftToRight(root.left,level-1);
			printLeftToRight(root.right,level-1);
		}
	}
	
	public void printRightToLeft(Node root,int level) {
		if(root==null) {
			return;
		}
		if(level==1) {
			System.out.println(root.data);
		}else if(level>1) {
			printLeftToRight(root.right,level-1);
			printLeftToRight(root.left,level-1);
		}
	}
	
	
	public int length(Node root) {
		if(root==null) {
			return 0;
		}
		
		int ll = length(root.left);
		int lr = length(root.right);
		
		return 1 +Math.max(ll, lr);
	}
	
	
	
	public void printSpiral(Node root) {
		int i=0;
		int j = length(root);
		
		int ltr =0;
		
		while(i<=j) {
			if(ltr==0) {
				printRightToLeft(root,i);
				i++;
				ltr=1;
			}else {
				printLeftToRight(root,j);
				j--;
				ltr=0;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
