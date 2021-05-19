package cisco.com.example;

public class QueueUsingLinkedList {

	Node front;

	public QueueUsingLinkedList() {
		this.front = null;
	}

	public Node push(int key) {

		Node temp1 = this.front;
		Node temp = new Node(key);
		if (front == null) {
			front = temp;
			return this.front;
		}

		while (temp1.next != null) {
			temp1 = temp1.next;
		}

		temp1.next = temp;
		return this.front;

	}
	
	public Node pop() {
		this.front = this.front.next;
		return this.front;
	}

	public static void main(String[] args) {

	}

}
