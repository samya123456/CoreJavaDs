package com.dfs;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestBridge934 {

	public static int shortestBridge(int[][] grid) {

		int n = grid.length;
		Map<String, Boolean> visited = new HashMap<>();

		Deque<String> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String key = "" + i + "-" + "" + j;
				if (visited.get(key)==null && grid[i][j] == 1) {
					dfs(grid, visited, i, j, n);

				}
			}
		}
		
		q.addAll(visited.keySet());
		return bfs(q, grid, visited, n);

	}

	private static int bfs(Deque<String> q, int[][] grid, Map<String, Boolean> visited, int n) {

		int res = 0;
		while (!q.isEmpty()) {

			int size = q.size();

			for (int k = 0; k < size; k++) {

				String strInd = q.removeFirst();
				String[] arr = strInd.split("-");
				int i = Integer.valueOf(arr[0]);
				int j = Integer.valueOf(arr[1]);
				String key = "";
				if (isValid(i + 1, j, n)) {
					int p = i + 1;
					key = "" + p + "-" + "" + j;
					if (visited.get(key) == null) {
						System.out.println(key);
						if (grid[p][j] == 1) {
							return res;
						}
						visited.put(key, true);
						q.addLast(key);

					}

				}
				if (isValid(i - 1, j, n)) {
					int p = i - 1;
					key = "" + p + "-" + "" + j;
					if (visited.get(key) == null) {
						System.out.println(key);
						if (grid[p][j] == 1) {
							return res;
						}
						visited.put(key, true);
						q.addLast(key);

					}
				}
				if (isValid(i, j + 1, n)) {
					int p = j + 1;
					key = "" + i + "-" + "" + p;
					if (visited.get(key) == null) {
						System.out.println(key);
						if (grid[i][p] == 1) {
							return res;
						}
						visited.put(key, true);
						q.addLast(key);

					}
				}
				if (isValid(i, j - 1, n)) {
					int p = j - 1;
					key = "" + i + "-" + "" + p;
					if (visited.get(key) == null) {
						System.out.println(key);
						if (grid[i][p] == 1) {
							return res;
						}
						visited.put(key, true);
						q.addLast(key);

					}
				}
			}

			res++;

		}
		return -1;
	}

	private static void dfs(int[][] grid, Map<String, Boolean> visited, int i, int j, int n) {

		String key = "" + i + "-" + "" + j;
		if (!isValid(i, j, n) || grid[i][j] != 1 || visited.get(key)!=null) {
			return;
		}
		
		
			//grid[i][j] =2;
			visited.put(key, true);
			
			dfs(grid, visited, i + 1, j, n);
			dfs(grid, visited, i - 1, j, n);
			dfs(grid, visited, i, j - 1, n);
			dfs(grid, visited, i, j + 1, n);

		
	}

	private static boolean isValid(int i, int j, int n) {
		if (i >= 0 && i < n && j >= 0 && j < n) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		int[][] grid = { { 0,1,0,0,0}, 
				         { 0,1,0,1,1}, 
				         { 0,0,0,0,1}, 
				         { 0,0,0,0,0},
				         { 0,0,0,0,0} };
		System.out.println(shortestBridge(grid));

	}

}
