package payPal;

public class LinkedListEx {
	
	public static class Node{
		Node next;
		int data;
		
		Node(int data){
			this.data = data;
			next =null;
		}
	}
	
	
	public  Node insert(Node head , int data) {
		Node temp = new Node(data);
		if(head == null)
			return temp;
		Node temp1=head;
		
		while(temp1.next!=null) {
			temp1 =temp1.next;
		}
		
		temp1.next = temp;
		return head;
		
	}
	
	public Node deleteNodeByKey(Node head, int key) {
		if(head.data==key) {
			head =head.next;
			return head;
		}
		
		Node prev =null;
		Node currNode = head;
		
		while(currNode!=null && currNode.data !=key) {
			prev = currNode;
			currNode =currNode.next;
		}
		if(currNode!=null) {
			prev.next = currNode.next;
		}
		
		return head;
		
	}
	
	
   static	void printNode(Node head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
   
   static int length(Node head) {
	   int count =0;
	   while(head!=null) {
		   count++;
		   head = head.next;
	   }
	   System.out.println(count);
	   return count;
   }
	
   
    Node reverseLinkedList(Node head) {
	   Node prev =null;
	   Node next =null;
	   
	   while(head!=null) {
		   next =head.next;
		   head.next = prev;
		   prev=head;
		   head=next;
	   }
	   
	   return prev;
   }
    
    Node detectAndremoveLoop(Node head) {
    	Node slow = head;
    	Node fast = head;
    	
    	while(fast!=null && fast.next!=null) {
    		slow =slow.next;
    		fast=fast.next.next;
    		if(slow==fast) {
    			head =removeLoop(slow,head);
    		}
    	}
    	
    	return head;
    }
	

	private Node removeLoop(Node loop, Node curr) {
		Node ptr1 = null;
	   Node ptr2 = null;
	   
	   ptr1 = curr;
	   while(1==1) {
		    ptr2 =loop;
		   while(ptr2.next!=loop && ptr2.next!= ptr1) {
			   ptr2=ptr2.next;
		   }
		   
		   if(ptr2.next==ptr1) {
			   break;
		   }
		   
		   ptr1 = ptr1.next;
	   }
	   
	   ptr2.next =null;
	   
	   return curr;
	  
		
	}
	
	Node sortedMerge(Node A,Node B) {
		if (A==null)
			return B;
		if(B==null)
			return A;
		if(A.data<B.data) {
			A.next = sortedMerge(A.next,B);
			return A;
		}
			
		else {
			B.next =sortedMerge(A,B.next);
			return B;
		}
		
	}
	
	public Node greaterLessNumber(Node head , int number) {
		Node greater =null;
		Node less=null;
		Node head1=null ;
		Node head2=null ;
		
		while(head!=null) {
			if(head.data>number) {
				if(greater==null) {
					greater = head;
					head1 =greater;
				}else {
					greater.next =head;
				}
				
				
				greater = greater.next;
				
			}else {
				if(less==null) {
					less = head;
					head2 = less;
				}else {
					less.next =head;
				}
				less = less.next;
			}
			
			head = head.next;
		}
		
			//greater=head2;
		
		
		return head1;
	}

	public static void main(String[] args) {
		
		/*Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		Node temp = new LinkedListEx().reverseLinkedList(head);
		printNode(temp);
		
		 Node head = new Node(50);
         head.next = new Node(20);
         head.next.next = new Node(15);
         head.next.next.next = new Node(4);
         head.next.next.next.next = new Node(10);
         head.next.next.next.next.next = head.next.next;
         
         Node temp = new LinkedListEx().detectAndremoveLoop(head);
         printNode(temp);
		
		Node head = new Node(1);
		head.next = new Node(10);
		head.next.next = new Node(13);
		
		Node head1 = new Node(2);
		head1.next = new Node(5);
		head1.next.next = new Node(11);*/
		
		 Node head = new Node(5);
         head.next = new Node(2);
         head.next.next = new Node(1);
         head.next.next.next = new Node(3);
         head.next.next.next.next = new Node(4);
		
		 Node temp = new LinkedListEx().greaterLessNumber(head,3);
         printNode(temp);
		

	}

}
