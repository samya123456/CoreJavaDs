package com.ds;

public class TreeWithRightSubLink {
	
	static class Node{
		Node left;
		Node right;
		Node next;
		int data;
		
		Node(int data){
			
			this.data = data;
		}
	}
	public void connectRightSublink(Node head) {
		if(head ==null) {
			return;
		}
		
		while(head.left!=null) {
			Node temp = head;
			while(head!=null) {
				head.left.next = head.right;
				head.right.next = head.next ==null?null:head.next.left;
				head =head.next;
			}
			head =temp.left;
		}
	}
	public static void main(String[] args) {



	}

}
