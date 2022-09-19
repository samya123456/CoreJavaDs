package com.ds;

public class RotateList61 {
	
	
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	
	 public static ListNode rotateRight(ListNode head, int k) {
	        ListNode current = head;
	       
	        int length = lenght(head);
	        k = k%length;
	        k = length-k;
	        while(current.next !=null){
	           
	            current = current.next;
	        }
	        current.next = head;
	        while(k>=1){
	            current = current.next;
	            k--;
	        }
	        ListNode newHead = current.next;
	        current.next =null;
	        return newHead;
	    }
	    
	    private static int lenght(ListNode root){
	        int count =0;
	        while(root!=null){
	            root =root.next;
	            count++;
	        }
	        return count;
	    }

	public static void main(String[] args) {
		ListNode root = new ListNode(0);
		root.next = new ListNode(1);
		root.next.next = new ListNode(2);
		/*root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);*/
		
		rotateRight(root, 4);
		

	}

}
