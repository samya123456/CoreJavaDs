package com.microsoft;

public class ExtractLeavesBTreeInDoublyLinkedList {
	
	
	Node head;
	Node root;
	Node prev;
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}

	public Node extractLeafList(Node root) {
		if(root==null) {
			return null;
		}
		
		if(root.left==null && root.right==null) {
			if(head==null) {
				head =root;
				prev = root;
			}else {
				prev.right=root;
				root.left = prev;
				prev = root;
			}
			return null;
		}
		root.left = extractLeafList(root.left);
		root.right = extractLeafList(root.right);
		return root;
	}
	
	public void printDLL(Node head) {
		Node last=null;
		
		while(head!=null) {
			System.out.println(head.data);
			last = head;
			head = head.right;
		}
	}
	
	public void inOrder(Node root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	public static void main(String[] args) {
		
		ExtractLeavesBTreeInDoublyLinkedList tree = new ExtractLeavesBTreeInDoublyLinkedList();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(8);
        tree.root.right.right.left = new Node(9);
        tree.root.right.right.right = new Node(10);
        System.out.println("Inorder traversal of given tree is : ");
        tree.inOrder(tree.root);
        tree.extractLeafList(tree.root);
        System.out.println("");
        System.out.println("Extracted double link list is : ");
        tree.printDLL(tree.head);
        System.out.println("");
        System.out.println("Inorder traversal of modified tree is : ");
        tree.inOrder(tree.root);
		

	}

}
