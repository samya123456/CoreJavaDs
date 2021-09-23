package com.example.linkedList;

public class ReverseLinkedListInGroupsOfGivenSize {
	
	
	public static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	
	public static Node reverseLinkedListInGroupsOfGivenSize(Node head,int k) {
		
		return reverse(head,k);
		
	}
	
	public static Node reverse(Node head,int k) {
		if(head==null || k==0) {
			return head;
		}
		
		Node curr = head;
		Node nextNode=null;
		Node prev = null;
		int count =0;
		while(count<k && curr!=null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
			count++;
		}
		
		if(nextNode!=null) {
			head.next = reverse(nextNode,k);
		}
		
		return prev;
	}

	public static void main(String[] args) {



	}

}
