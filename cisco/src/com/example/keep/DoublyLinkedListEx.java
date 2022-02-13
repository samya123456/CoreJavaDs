package com.example.keep;

public class DoublyLinkedListEx {
	
	//KEY POINT of DOUBLY LINKED LIST IS ANY node.prev or node.next will always point to it's previous or next node NOT
	//to any node's .prev or .next node.

	static class DoublyLinkedList {
		
		DoublyLinkedList next;
		DoublyLinkedList prev;
		int data;

		DoublyLinkedList(int data) {
			this.data = data;
		}
	}
	
	public static DoublyLinkedList insertFirst(DoublyLinkedList new_node, DoublyLinkedList head) {
		new_node.next = head;
		head.prev = new_node;
		new_node.prev =null;
		head = new_node;
		return head;
	}
	
	public static DoublyLinkedList insertMiddle(DoublyLinkedList new_node, DoublyLinkedList head ,int pos) {
		DoublyLinkedList temp = head;
		while(pos!=1) {
			temp =temp.next;
			pos--;
		}
		new_node.next = temp.next;
		temp.next.prev = new_node;
		temp.next =new_node;
		new_node.prev = temp;
		
		return head;
	}
	
	public static DoublyLinkedList insertLast(DoublyLinkedList new_node, DoublyLinkedList head) {
		DoublyLinkedList temp =head;
		DoublyLinkedList last = null;
		while(temp!=null) {
			last=temp;
			temp =temp.next;
		}
		last.next = new_node;
		new_node.prev = last;
		new_node =null;
		return head;
		
		
	}
	
	public static DoublyLinkedList deleteMiddle( DoublyLinkedList head,int pos) {
		DoublyLinkedList temp= head; 
		while(pos!=2) {
			temp =temp.next;
			pos--;
		}
		
		temp.next.next.prev =temp;
		temp.next = temp.next.next;
		return head;
		
		
	}
	
	
	private static void printForwardNReverse(DoublyLinkedList head) {
		System.out.println("Forward........." );
		DoublyLinkedList last=null;
		while(head!=null) {
			System.out.println(head.data);
			last = head;
			head = head.next;
		}
		
		System.out.println("backward........." );
		
		while(last!=null) {
			System.out.println(last.data);
			last = last.prev;
		}
		
	}

	public static void main(String[] args) {
		
		DoublyLinkedList nodeOne = new DoublyLinkedList(1);
		nodeOne.prev =null;
		DoublyLinkedList nodeTwo = new DoublyLinkedList(2);
		nodeOne.next = nodeTwo;
		nodeTwo.prev = nodeOne;
		DoublyLinkedList nodeThree = new DoublyLinkedList(3);
		nodeTwo.next =nodeThree;
		nodeThree.prev =nodeTwo;
		nodeThree.next =null;
		
		DoublyLinkedList new_node = new DoublyLinkedList(0);
		nodeOne =insertFirst(new_node,nodeOne);
		DoublyLinkedList new_node_insert = new DoublyLinkedList(5);
		nodeOne =insertMiddle(new_node_insert,nodeOne,3);
		
		DoublyLinkedList new_node_insert_last = new DoublyLinkedList(8);
		nodeOne = insertLast(new_node_insert_last,nodeOne);
		nodeOne = deleteMiddle(nodeOne,3);
		printForwardNReverse(nodeOne);
		

	}

}
