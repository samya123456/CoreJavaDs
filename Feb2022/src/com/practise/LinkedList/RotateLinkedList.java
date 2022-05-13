package com.practise.LinkedList;



public class RotateLinkedList {
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
	}
	
	public static Node rotate(Node head ,int k) {
		if(k==0|| head==null) {
			return head;
		}
		
		int len = length(head);
		Node temp = head;
		
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next= head;
		temp = temp.next;
		
		k = k%len;
		k= len -k;
		Node prev =null;
		while(k>0) {
			prev=temp;
			temp = temp.next;
			k--;
		}
		
		prev.next=null;
		return temp;
	}

	private static int length(Node head) {
		int count=0;
		while(head!=null) {
			head=head.next;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		

	}

}
