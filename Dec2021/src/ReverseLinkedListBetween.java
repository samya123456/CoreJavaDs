
public class ReverseLinkedListBetween {

	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public static Node reverseBetween(Node head, int left, int right) {
		Node prev = null;
		Node current = head;
		while (left > 1) {
			prev = current;
			current = current.next;
			left--;
			right--;
		}

		Node connection = prev;
		Node tail = current;

		while (right > 0) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			right--;

		}
		if (connection != null) {
			connection.next = prev;
		} else {
			head = prev;
		}
		tail.next = current;
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		reverseBetween(head,2,4);
		while(head!=null) {
			System.out.println(head.val);
			head =head.next;
		}
		
	}

}
