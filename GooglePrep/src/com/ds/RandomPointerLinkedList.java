package com.ds;

public class RandomPointerLinkedList {
	
	static class Node{
		Node next;
		Node random;
	    int data;
	    
	    Node (int val){
	    	this.data = val;
	    	next =random=null;
	    }
	}
	
	
	public static Node cloneRandom(Node head) {
		
		Node temp = head;
		
		while(temp!=null) {
			Node next = temp.next;
			temp.next = new Node(temp.data);
			temp.next.next  =next;
			temp =temp.next.next;
		}
		
		temp =head;
		
		while(temp!=null) {
			if(temp.next!=null) {
				temp.next.random =  temp.random==null? null:temp.random.next;
				temp =temp.next.next;
			}
			
		}
		
		Node org = head;
		Node copy = head.next;
		Node temp1 = copy;
		
		while(org !=null) {
			org.next = org.next.next;
			copy.next = copy.next.next;
			org = org.next;
			copy =copy.next;
		}
		
		return temp1;
		
	}

	public static void main(String[] args) {
		

	}

}
