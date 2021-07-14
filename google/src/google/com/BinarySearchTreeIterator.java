package google.com;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIterator {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	
	
	
	private Queue<Integer> q = new LinkedList<Integer>();

	public BinarySearchTreeIterator(TreeNode root) {
		
		inOrderTravalsal(root);
	}

	public int next() {

		return q.poll();
	}

	public boolean hasNext() {
		return q.isEmpty();
	}
	
	
	private void inOrderTravalsal(TreeNode root) {
		if(root==null) {
			return;
		}
		
		inOrderTravalsal(root.left);
		q.add(root.val);
		inOrderTravalsal(root.right);
		
				
	}

	public static void main(String[] args) {
		

	}

}
