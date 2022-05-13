package com.practise.LinkedList;


public class DetectNRemoveLoopLinledList {
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next =null;
		}
	}
	
	public void detectNRemoveLoop(Node head) {
		if(head==null || head.next==null) {
			return;
		}
		Node slow =head;
		Node fast = head;
		
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast =fast.next.next;
			if(fast==slow) {
				break;
			}
		}
		
		if(fast==slow) {
			slow =head;
			
			if(slow!=fast) {
				while(slow.next!=fast.next) {
					slow =slow.next;
					fast = fast.next;
				}
				
			}else {
				while(fast.next!=slow) {
					fast =fast.next;
				}
			}
			fast.next =null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
