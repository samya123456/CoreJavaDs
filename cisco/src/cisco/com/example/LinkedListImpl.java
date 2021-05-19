package cisco.com.example;

public class LinkedListImpl {
	
	public Node insert(Node head,int key) {
		Node temp = new Node(key);
		
		if (head==null) {
			head= temp;
			return head;
		}
		Node temp1 = head;
		while(temp1.next!=null) {
			temp1= temp1.next;
		}
		
		temp1.next =temp;
		return head;
	}
	
	public Node deleteNodeByKey(Node head,int key) {
		Node currNode = head;
		Node prev = null;
		
		if(currNode!=null && currNode.data==key) {
			currNode = currNode.next;
			head = currNode;
			return head;
		}
		
		while(currNode!=null && currNode.data!=key) {
			prev = currNode ;
			currNode = currNode.next;
		}
		
		if(currNode!=null) {
			prev.next= currNode.next;
			
		}
		
		return head;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
