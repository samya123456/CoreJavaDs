package com.microsoft;

import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
	
	static class Node 
	{
	    int data;
	    Node next;
	    
	    Node(int a)
	        {
	            data = a;
	            next = null;
	        }
	}
	
	 public static Node findIntersection(Node head1, Node head2)
	    {
	       Set<Integer> set = new LinkedHashSet<Integer>();
	       while(head2!=null){
	           set.add(head2.data);
	           head2 = head2.next;
	       }
	       Node current =null;
	       Node op=null;
	       while(head1!=null){
	           if(set.contains(head1.data)){
	               if( current ==null){
	                   current = new Node(head1.data);
	                   op = current;
	                   
	               }else{
	            	   
	                   current.next = new Node(head1.data);
	                   current = current.next;
	                   
	               }
	           }
	           head1 = head1.next;
	       }
	       
	       return op;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node(9);
		head1.next = new Node(6);
		head1.next.next = new Node(4);
		head1.next.next.next= new Node(2);
		head1.next.next.next.next= new Node(3);
		head1.next.next.next.next.next= new Node(3);
		
		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next  = new Node(8);
		head2.next.next.next= new Node(6);
		
		findIntersection(head1,head2);
		
		

	}

}
