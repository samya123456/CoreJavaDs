package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

	static class PriceNode implements Comparable<PriceNode> {
		int currNode;
		int price;
		int stops;

		PriceNode(int currNode, int price, int stops) {

			this.currNode = currNode;
			this.price = price;
			this.stops = stops;
		}

		public int compareTo(PriceNode other) {

			return this.price - other.price;
		}
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		List<List<Integer>> adj_List[] = new ArrayList[n];
		populateAdjList(flights, adj_List);
		return bfs(n, adj_List, src, dst, k);

	}

	private static int bfs(int n, List<List<Integer>>[] adj_List, int src, int dst, int k) {
		PriorityQueue<PriceNode> minHeap = new PriorityQueue<>();
		int[] priceArr = new int[n];
		int[] stops = new int[n];
		Arrays.fill(priceArr, Integer.MAX_VALUE);
		Arrays.fill(stops, Integer.MAX_VALUE);
		priceArr[src] = 0;
		stops[src] = 0;
		PriceNode source = new PriceNode(src, 0, 0);
		minHeap.add(source);

		while (!minHeap.isEmpty()) {
			PriceNode currPriceNode = minHeap.remove();
			int parent = currPriceNode.currNode;
			int price = currPriceNode.price;
			int stop = currPriceNode.stops;

			if (parent == dst) {
				return price;
			}
			if (stop == k + 1) {
				continue;
			}
			List<List<Integer>> children = adj_List[parent];
			if (children != null) {
				for (int i = 0; i < children.size(); i++) {
					List<Integer> childNode = children.get(i);
					int child = childNode.get(0);
					int childPrice = childNode.get(1) + price;
					int totalStops = stop + 1;
					if (priceArr[child] > childPrice) {
						priceArr[child] = childPrice;
						stops[child] = totalStops;
						minHeap.add(new PriceNode(child, childPrice, totalStops));
					} else if (stops[child] > totalStops) {
						stops[child] = totalStops;
						minHeap.add(new PriceNode(child, childPrice, totalStops));
					}
				}
			}
		}
		return -1;
	}

	private static void populateAdjList(int[][] flights, List<List<Integer>> adj_List[]) {

		for (int i = 0; i < flights.length; i++) {
			int parent = flights[i][0];
			int child = flights[i][1];
			int price = flights[i][2];

			if (adj_List[parent] == null) {
				List<List<Integer>> children = new ArrayList<List<Integer>>();
				List<Integer> childPrice = new ArrayList<>();
				childPrice.add(child);
				childPrice.add(price);
				children.add(childPrice);
				adj_List[parent] = children;
			} else {
				List<List<Integer>> children = adj_List[parent];
				List<Integer> childPrice = new ArrayList<>();
				childPrice.add(child);
				childPrice.add(price);
				children.add(childPrice);
				adj_List[parent] = children;
			}
		}
	}

	public static void main(String[] args) {
		int n = 3;
		int[][]flights = {{0,1,100},{1,2,100},{0,2,500}};
		int src = 0;
		int dst = 2; 
		int k = 1;
		
		System.out.println(findCheapestPrice(n,flights,src,dst,k));

	}

}
