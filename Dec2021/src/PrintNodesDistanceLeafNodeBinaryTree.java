
public class PrintNodesDistanceLeafNodeBinaryTree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void printNodes(Node root, int k) {

		int n = height(root);
		int arr[] = new int[n];
		boolean visited[] = new boolean[n];

		printNodesUtil(root, arr, visited, k, 0);

	}

	private static void printNodesUtil(Node root, int[] arr, boolean[] visited, int k, int count) {
		if (root == null) {
			return;
		}
		arr[count] = root.data;
		visited[count] = false;

		if (root.left == null && root.right == null && count - k >= 0 && !visited[count - k]) {
			System.out.println(arr[count - k]);
			visited[count - k] = true;
			return;
		}
		printNodesUtil(root.left, arr, visited, k, count + 1);
		printNodesUtil(root.right, arr, visited, k, count + 1);

	}

	private static int height(Node root) {
		if (root == null)
			return 0;

		return 1 + Math.max(height(root.left), height(root.right));
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
		
		printNodes(n1,1);

	}

}
