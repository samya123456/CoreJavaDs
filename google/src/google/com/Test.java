package google.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
		int len = length(head);
	       
        int k = len -n;
        if(k==1 &&n==1){
            return null;
        }
		ListNode prev = head;
		ListNode temp = head;
		while (len>=1 && k != 0) {
			prev = temp;
			temp = temp.next;
			k--;
		}
		if (temp != null) {
			prev.next = temp.next;
		}

		return head;
	}

	static int length(ListNode head) {
		int op = 0;
		if (head == null)
			return 0;
		while (head != null) {
			op++;
			head = head.next;
		}
		return op;
	}
	
	
	 public static ListNode deleteDuplicates(ListNode head) {
	        
	        ListNode prev = head;
	        ListNode temp =head;
	        ListNode fast =new ListNode();
	        HashSet<Integer> st = new HashSet<Integer>();
	        
	        while(temp!=null){
	            if(!st.contains(temp.val)){
	                st.add(temp.val);
	                fast = prev;
	                prev = temp;
	                
	            }else {
	                if(temp.next!=null){
	                    fast.next = temp.next.next;
	                }
	            }
	            
	            temp =temp.next;
	        }
	        
	        return head;
	        
	    }
	 
	 public static ListNode deleteDuplicatesV2(ListNode head) {
		    ListNode temp = head;
	        Map<Integer,Integer> st = new HashMap<Integer,Integer>();
	        
	        while(temp!=null){
	            if(!st.containsKey(temp.val)){
	                st.put(temp.val, 1);
	                
	                
	            }else {
	            	int x =st.get(temp.val);
	            	st.put(temp.val, x+1);
	            }
	            
	            temp =temp.next;
	        }
	       
	        ListNode temp1 = new ListNode();
	        ListNode op = temp1;
	        int count =0;
	        boolean firstNode;
	        for(Entry<Integer, Integer> entry :st.entrySet()) {
	        	if(st.size()==1 && entry.getValue()!=1) {
	        		return null;
	        	}
	        	
	        	count++;
	        	if(entry.getValue()==1) {
	        		
		        	temp1.val = entry.getKey();
		        	if(count!=st.size()) {
		        		temp1.next = new ListNode();
			        	temp1 = temp1.next;
		        	}
	        	}else {
	        		temp1.next =null;
	        	}
	        	
	        	
	        }
	        
	        return op;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head =new ListNode(1);
		head.next =new ListNode(2);
		head.next.next = new ListNode(2);
		/*head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next= new ListNode(5); */
		
		deleteDuplicatesV2(head);
		
		//removeNthFromEnd(head,2);

	}

}
