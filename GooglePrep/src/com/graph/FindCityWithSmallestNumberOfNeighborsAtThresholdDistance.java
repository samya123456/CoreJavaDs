package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindCityWithSmallestNumberOfNeighborsAtThresholdDistance {

	static class CityDistance implements Comparable<CityDistance> {
		int city;
		int numOfCity;
		int distanceThreshold;

		CityDistance(int city, int numOfCity, int distanceThreshold) {
			
			this.city = city;
			this.numOfCity = numOfCity;
			this.distanceThreshold = distanceThreshold;

		}

		public int compareTo(CityDistance other) {

			return this.distanceThreshold - other.distanceThreshold;
		}

	}

	public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

		List<List<Integer>> adj_list[] = new ArrayList[n];
		populateAdjList(edges, adj_list);
		
		int[] distanceThresholdArr = new int[n];
		int[] numOfCityArr = new int[n];
		
		Arrays.fill(distanceThresholdArr, Integer.MAX_VALUE);
		//Arrays.fill(numOfCityArr, Integer.MAX_VALUE);
		for(int i =0;i<n;i++) {
			bfs(adj_list,distanceThreshold,distanceThresholdArr,numOfCityArr,i);
		}

		return -1;
	}
	
	
	
	private static int bfs(List<List<Integer>> adj_list[], int distanceThreshold,int[] distanceArr,int[] numOfCityArr,int src) {
		

		PriorityQueue<CityDistance> minHeap = new PriorityQueue<>();
		minHeap.add(new CityDistance(src, 0, 0));

		while (!minHeap.isEmpty()) {
			CityDistance current = minHeap.remove();
			int parent = current.city;
			int numOfCity = current.numOfCity;
			int distanceThresholdParent = current.distanceThreshold;
			
			if(distanceThresholdParent > distanceArr[src]   ) {
				continue;
			}
			
			List<List<Integer>> children = adj_list[parent];
			if (children != null) {

				for (int i = 0; i < children.size(); i++) {

					int childNode = children.get(i).get(0);
					int nodeDistance = children.get(i).get(1) + distanceThresholdParent;
					int newNumofCity = numOfCity + 1;
					
					if(distanceArr[childNode] > nodeDistance) {
					   distanceArr[childNode] = nodeDistance;
					   numOfCityArr[childNode]++;
					   minHeap.add(new CityDistance(childNode,newNumofCity,distanceArr[childNode]));
					}
					

					

				}

			}

		}
		
		return -1;

	}

	private static void populateAdjList(int[][] edges, List<List<Integer>> adj_List[]) {

		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			int weight = edges[i][2];

			if (adj_List[parent] == null) {
				List<List<Integer>> children = new ArrayList<List<Integer>>();
				List<Integer> childWeight = new ArrayList<>();
				childWeight.add(child);
				childWeight.add(weight);
				children.add(childWeight);
				adj_List[parent] = children;
			} else {
				List<List<Integer>> children = adj_List[parent];
				List<Integer> childWeight = new ArrayList<>();
				childWeight.add(child);
				childWeight.add(weight);
				children.add(childWeight);
				adj_List[parent] = children;
			}
			if (adj_List[child] == null) {
				List<List<Integer>> children = new ArrayList<List<Integer>>();
				List<Integer> childWeight = new ArrayList<>();
				childWeight.add(parent);
				childWeight.add(weight);
				children.add(childWeight);
				adj_List[child] = children;
			} else {
				List<List<Integer>> children = adj_List[child];
				List<Integer> childWeight = new ArrayList<>();
				childWeight.add(parent);
				childWeight.add(weight);
				children.add(childWeight);
				adj_List[child] = children;
			}
		}
	}

	public static void main(String[] args) {
		
		
		int n = 4;
		int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
		int distanceThreshold = 4;
		System.out.println(findTheCity(n,edges,distanceThreshold));

	}

}
