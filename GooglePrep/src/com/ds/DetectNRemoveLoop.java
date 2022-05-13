package com.ds;

import java.util.HashSet;
import java.util.Set;

public class DetectNRemoveLoop {
	
	static class Node{
		Node next;
		int data;
		
		Node(int data){
			this.data =data;
		}
	}
	
	
	public static boolean detectNRemoveLoopUsingSet(Node head) {
		Set<Node> set = new HashSet<Node>();
		Node prev =null;
		
		while(head!=null) {
		   if(!set.contains(head)) {
			   set.add(head);
			   prev =head;
			   head =head.next;
		   }else {
			   prev.next =null;
			   return true;
		   }
		}
		return false;
	}
	
	public static boolean detectNRemoveLoopWithoutUsingSet(Node head) {
		
		boolean loop =false;
		
		Node fast = head;
		Node slow = head;
		
		while (fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow =slow.next;
			
			if(fast==slow) {
				loop =true;
				break;
			}
		}
			
			if(loop) {
				slow =head;
				
				if(slow!=fast) {
					while(fast.next!=slow.next) {
						fast =fast.next;
						slow =slow.next;
					}
					fast.next =null;
				}else {
					while(fast.next!=slow) {
						fast =fast.next;
					}
					fast.next =null;
				}
			}
		
		
		return loop;
		
	}
	
	

	public static void main(String[] args) {
		
		
	        Node head = new Node(50);
	        head.next = new Node(20);
	        head.next.next = new Node(15);
	        head.next.next.next = new Node(4);
	        head.next.next.next.next = new Node(10);
	 
	        // Creating a loop for testing
	        head.next.next.next.next.next = head.next.next;
	        detectNRemoveLoopWithoutUsingSet(head);
	        System.out.println("Linked List after removing loop : ");
		       while(head!=null) {
		    	   System.out.println(head.data);
		    	   head =head.next;
		       }
		

	}

}
