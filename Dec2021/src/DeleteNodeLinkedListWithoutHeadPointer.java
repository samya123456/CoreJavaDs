
public class DeleteNodeLinkedListWithoutHeadPointer {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void deleteNodeLinkedListWithoutHeadPointer(Node position) {
		
		if(position==null) return;
		
		if(position.next==null) {
			System.out.println("Last Node");
			return;
		}
	
		position.data = position.next.data;
		position.next = position.next.next;
		
		
		
	}

	public static void main(String[] args) {
		
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
		deleteNodeLinkedListWithoutHeadPointer(n1.next);
		while(n1!=null) {
			System.out.println(n1.data);
			n1 = n1.next;
		}

	}

}
