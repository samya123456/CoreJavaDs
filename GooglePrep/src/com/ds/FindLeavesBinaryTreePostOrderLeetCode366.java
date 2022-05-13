package com.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class FindLeavesBinaryTreePostOrderLeetCode366 {
	
	static class TreeNode {
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
	Map<Integer, List<Integer>> map = new HashMap<>();

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		height(root);
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;

	}

	private int height(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int height = Math.max(height(root.left), height(root.right)) + 1;
		if (map.containsKey(height)) {
			map.get(height).add(root.val);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			map.put(height, list);
		}

		return height;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
