
public class InOrderTravalsalBST {

	static int count = 0;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = right = null;

		}
	}

	public static void inOrder(Node root, int k) {

		if (root == null)
			return;
		inOrder(root.left, k);
		if (++count == k) {

			System.out.println(root.data);
			return;
		}
		inOrder(root.right, k);

	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		inOrder(root, 2);

		// System.out.println(list.get(2));

	}

}
