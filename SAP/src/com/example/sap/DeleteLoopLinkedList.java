package com.example.sap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class DeleteLoopLinkedList {
	

    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        
        detectloop(head);
        
    }
    
    public static void detectloop(Node head){
        Node slow = head;
        Node fast =head;
        
        while(fast!=null && fast.next !=null){
            slow =slow.next;
            fast = fast.next.next;
            
            if(slow==fast){
                
                removeloop(slow ,head);
                
                
            }
        }
        
        
    }
    
    public static void detectloopUsingMap(Node head){
    	
    	LinkedHashSet<Node> set = new LinkedHashSet<Node>();
    	Node ptr2=null;
    	
    	while(head.next!=null) {
    		if(!set.contains(head)) {
    			set.add(head);
    			head =head.next;
    		}else {
    			break;
    		}
    		
    	}
    	//Iterator<Node> itr = set.iterator();
    	
    	List<Node> al = new ArrayList<Node>(set);
    	ptr2 = al.get(0);
    	Node ptr3 =ptr2;
    	for(int i=1;i<al.size();i++) {
    		ptr3 =ptr3.next;
    		ptr3= al.get(i);
    	}
    	ptr3.next=null;
    	
    }
    
    int getNthFromLast(Node head, int n)
    {
        Node temp = head;
     int p = length(head);
     int k= p-n;
     
     while(k>0){
        temp =temp.next; 
        k--;
     }
     return temp.data;
    }
    
    int length(Node head){
        int size = 0;
        
        while(head!=null){
            head = head.next;
            size++;
        }
        
        return size;
    }
    
    public static void removeloop(Node loop , Node curr){
        Node ptr1=null;
        Node ptr2 =null;
        
        ptr1=curr;
        
        while(true){
            ptr2=loop;
            
            while(ptr2.next!=loop && ptr2.next!=ptr1){
                ptr2=ptr2.next;
            }
            
            if(ptr2.next==ptr1){
                break;
            }
            
            ptr1 =ptr1.next;
        }
        
        ptr2.next =null;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(6);
        
        new DeleteLoopLinkedList().getNthFromLast(head, 2);
       
 
       
       
	}

}
