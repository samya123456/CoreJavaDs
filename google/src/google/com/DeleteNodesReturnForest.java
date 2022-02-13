package google.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesReturnForest {

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

	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> toDelete = new HashSet<Integer>();
		for (int i : to_delete) {
			toDelete.add(i);
		}

		List<TreeNode> remaining = new ArrayList<TreeNode>();

		dfs(root, toDelete, remaining);
		return remaining;

	}

	private static TreeNode dfs(TreeNode root, Set<Integer> toDelete, List<TreeNode> remaining) {
		if (root == null) {
			return null;
		}

		root.left = dfs(root.left, toDelete, remaining);
		root.right = dfs(root.right, toDelete, remaining);

		if (toDelete.contains(root.val)) {
			if (root.left != null) {
				remaining.add(root.left);
			}
			if (root.right != null) {
				remaining.add(root.right);
			}
		}

		return root;

	}

	public static void main(String[] args) {

	}

}
