import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class InverseLevelOrderTravarsal {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public static void inverLevelOrderTravarsal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		List<Node> list = new ArrayList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			list.add(temp);
			
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
		
		for(int i = list.size()-1;i>=0;i--) {
			System.out.println(list.get(i).data);
		}
		
	}

	public static void main(String[] args) {
		Node n1 = new Node(2);
		n1.left = new Node(7);
		n1.right = new Node(9);
		n1.left.left = new Node(10);
		n1.left.right = new Node(6);
		n1.left.right.left = new Node(5);
		n1.left.right.right = new Node(11);
		n1.right.right = new Node(9);
		inverLevelOrderTravarsal(n1);

	}

}
