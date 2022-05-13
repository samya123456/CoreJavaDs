package com.leetcode;

public class RemoveLinkedListElements203_Microsoft {
	
	static class ListNode{
		ListNode next;
		int val;
		ListNode(int val){
			this.val = val;
			next=null;
		}
	}
	
	 public static ListNode removeElements(ListNode head, int val) {
	        if(head==null){
	            return head;
	        }
	        
	        while(head!=null && head.val==val){
	            head = head.next;
	        }
	        
	        if(head==null){
	            return head;
	        }
	        
	        ListNode temp = head.next;
	        ListNode prev = head;
	        while(temp!=null){
	            if(temp.val==val){
	               prev.next = temp.next;  
	            }else{
	                prev =temp;
	            }
	           
	            temp = temp.next;
	        }
	        
	        return head;
	        
	    }

	public static void main(String[] args) {
		ListNode head =new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		removeElements(head,6);

	}

}
