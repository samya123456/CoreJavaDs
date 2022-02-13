package com.interview.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	public int bfs(int source, int destination) {
		boolean visited[] = new boolean[adj.length];
		Queue<Integer> q = new LinkedList<Integer>();
		int[] parent = new int[adj.length];
		q.add(source);
		visited[source] = true;
		parent[source] = -1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == destination)
				break;
			for (int neighbor : adj[cur]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					parent[neighbor] = cur;
					q.add(neighbor);

				}
			}
		}
		int distance =0;
		int temp = destination;
		while (parent[temp] != -1) {
			System.out.print(temp + " -->");
			temp = parent[temp];
			distance++;
		}
		return distance;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertexes and edges");
		int v = sc.nextInt();
		int e = sc.nextInt();
		Graph graph = new Graph(v);
		System.out.println("Enter edges");
		for (int i = 0; i < e; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			graph.addEdge(source, destination);
		}
		sc.close();
		int dist =graph.bfs(0,3);
		System.out.println(dist);

	}

}
