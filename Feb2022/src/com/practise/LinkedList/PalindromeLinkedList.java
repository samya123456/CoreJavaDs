package com.practise.LinkedList;

public class PalindromeLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public boolean isPalindrome(Node head) {
		Node fast = head;
		Node slow = head;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		slow = reverse(slow);
		fast = head;
		
		while(slow!=null) {
			if(slow.data!=fast.data) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		
		return true;
	}

	private Node reverse(Node head) {
		Node prev = null;
		Node next = null;
		while(head!=null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head.next =next;
			
		}
		
		return prev;
	}

	public static void main(String[] args) {

	}

}
