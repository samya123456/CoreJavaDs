package com.microsoft;



public class MergeShortLinkedList {
	
	static class Node{
		Node next;
		int val;
		
		Node(int val){
			this.val = val;
		}
	}
	
	public static Node mergeSort(Node root) {
		
		if(root ==null || root.next ==null) {
			return root;
		}
		
		Node middle = getMiddle(root);
		Node nextToMidde = middle.next;
		middle.next =null;
		Node left =mergeSort(root);
		Node right = mergeSort(nextToMidde);
		Node result = sortedMerge(left,right);
		return result;
	}

	private static Node sortedMerge(Node left, Node right) {
		if(left==null) return right;
		if(right==null) return left;
		
		if(left.val<right.val) {
			left.next = sortedMerge(left.next,right);
			return left;
		}else {
			right.next = sortedMerge(left,right.next);
			return right;
		}

	}

	private static Node getMiddle(Node root) {
		Node fast = root;
		Node slow = root;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow =slow.next;
			fast = fast.next.next;
			
		}
		return slow;
	}

	public static void main(String[] args) {
		 Node head = new Node(1);
		 head.next = new Node(2);
		 head.next.next = new Node(8);
		 head.next.next.next = new Node(4);
		 
		Node sortedList =  mergeSort(head);
		
		while(sortedList!=null){
			System.out.println(sortedList.val);
			sortedList = sortedList.next;
		}
		

	}

}
