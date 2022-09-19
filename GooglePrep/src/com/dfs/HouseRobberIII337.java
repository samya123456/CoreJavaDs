package com.dfs;

public class HouseRobberIII337 {

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

	public static int rob(TreeNode root) {
		
		int[] path = dfs(root);
		return Math.max(path[0], path[1]);
	}

	private static int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[]{0,0};
		}

		int[] leftPath = dfs(root.left);
		int[] rightPath = dfs(root.right);

		int withRoot = root.val + leftPath[1] + rightPath[1];
		int withOutRoot = Math.max(leftPath[0], leftPath[1]) + Math.max(rightPath[0], rightPath[1]);
		
		return new int[]{withRoot,withOutRoot};

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		
		System.out.println(rob(root));

	}

}
