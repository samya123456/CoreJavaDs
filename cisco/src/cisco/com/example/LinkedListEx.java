package cisco.com.example;

public class LinkedListEx {
	
	public Node findTheMiddleNode(Node head) {
		
		Node temp = head;
		Node fast = temp;
		
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			temp=temp.next;
		}
		
		return temp;
	}
	
	public Node reverseLinkedList(Node head) {
		Node prev =null;
		Node next =null;
		while(head!=null) {
			next =head.next;
			head.next =prev;
			prev =head;
			head = next;
		}
		
		return prev;
	}
	
	public Node counterClockWiseRotation(Node head, int n)  {
		int k =n;
		Node temp = head;
		while(n>1) {
			n--;
			temp=temp.next;
		}
		Node newHead= temp.next;
		Node newTemp = newHead;
		
		while(newTemp.next!=null) {
			newTemp = newTemp.next;
		}
		
		while(k>0) {
			newTemp.next = head;
			head =head.next;
			newTemp = newTemp.next;
			k--;
		}
		
		newTemp.next =null;
		
		return newHead;
		
	}
	
	public boolean detectLoop(Node head) {
		boolean flag = false;
		Node slow = head;
		Node fast = head;
		
		while(fast.next!=null && fast.next.next!= null) {
			
			slow=slow.next;
			fast =fast.next.next;
			if(fast==slow)
				flag =true;
			removeLoop(slow,head);
			
			
		}
		return flag;
	}
	
	public void removeLoop(Node loop, Node head) {
		
		Node ptr1 ;
		Node ptr2 ;
		ptr1 = head;
		
		while(true) {
			ptr2=loop;
			
			while(ptr2.next!=loop && ptr2.next !=head) {
				ptr2 =ptr2.next;
			}
			
			if(ptr2.next== ptr1) {
				break;
			}
			
			ptr1 =ptr1.next;
		}
		
		ptr2.next =null;
	}

	public static void main(String[] args) {
		
		
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = head.next.next;
		
		
		
		//System.out.println(new LinkedListEx().findTheMiddleNode(head).data);
		/*Node temp = new LinkedListEx().counterClockWiseRotation(head,3);
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}*/
		
		System.out.println(new LinkedListEx().detectLoop(head));
		

	}

}
