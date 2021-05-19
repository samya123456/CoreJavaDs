package com.leetcode.example;

public class NodeEx {
	
	public static class ListNode {
		     int val;
		      ListNode next;
		      ListNode() {
		    	  next=null;
		      }
		      ListNode(int val) { this.val = val; }
		      
		  }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode head = temp ;
        while(l1.next!=null && l2.next!=null){
            if(l1.val>l2.val){
                temp.next = l1 ;
                l1=l1.next;
                
            }else{
                temp.next = l2 ;
                l2=l2.next;
            }
           
            
            temp=temp.next;
        }
        
        while(l1.next!=null){
            temp.next =l1;
            temp =temp.next;
            l1=l1.next;
        }
         while(l2.next!=null){
            temp.next =l1;
            temp =temp.next;
            l2=l2.next;
        }
        return head;
    }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode op =new  ListNode(); 
        ListNode head =op;
        int rem =0;
        while(l1!=null && l2!=null){
            op.val = (l1.val + l2.val + rem)%10;
            rem =  (l1.val + l2.val+ rem)/10;
            if(l1.next!=null || l2.next!=null){
               op.next = new ListNode();
               op =op.next; 
            }
            
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null){
        	 op.val = (l1.val+rem)%10;
             rem = (l1.val+rem)/10;
             if(l1.next!=null){
             op.next = new ListNode();
             op =op.next;   
             }
             
             l1=l1.next;
        }
        
        while(l2!=null){
        	op.val = (l2.val+rem)%10;
            rem = (l2.val+rem)/10;
             if(l2.next!=null){
            op.next = new ListNode();
            op =op.next;  
             }
            l2=l2.next;
        }
        
        if(rem>0){
        	 op.next = new ListNode();
             op =op.next;
            op.val= rem;
        }else{
            op =null;
        }
        return head;
        
    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next =new ListNode(7);
		//l1.next.next =new ListNode(1);
		//l1.next.next.next =new ListNode(0);
		/*
		 * l1.next.next.next.next =new ListNode(9); l1.next.next.next.next.next =new
		 * ListNode(9); l1.next.next.next.next.next.next =new ListNode(9);
		 */
		
		
		ListNode l2 = new ListNode(9);
		l2.next =new ListNode(2);
		/*
		 * l2.next =new ListNode(9); l2.next.next =new ListNode(9); l2.next.next.next
		 * =new ListNode(9);
		 */
		ListNode x =new NodeEx().addTwoNumbers(l1, l2);
		while(x!=null) {
			System.out.println(x.val);
			x=x.next;
		}

	}

}
