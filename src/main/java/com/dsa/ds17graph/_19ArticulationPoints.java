package com.dsa.ds17graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _19ArticulationPoints {

	private int time;

	// Articulation point/cut vertex: removing this vertex increases the number of connected components.
	// Time Complexity: O(V + E), Space Complexity: O(V)
	public List<Integer> articulationPoints(List<List<Integer>> adj,int vertices){
		validateGraph(adj,vertices);

		boolean[] visited = new boolean[vertices];
		boolean[] articulationPoint = new boolean[vertices];
		int[] discoveryTime = new int[vertices];
		int[] lowTime = new int[vertices];
		int[] parent = new int[vertices];

		Arrays.fill(parent,-1);

		time = 0;

		// Run DFS from every unvisited vertex to handle disconnected graphs too.
		for (int i = 0 ; i < vertices ; i++){
			if (!visited[i]){
				dfs(adj,i,visited,articulationPoint,discoveryTime,lowTime,parent);
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0 ; i < vertices ; i++){
			if (articulationPoint[i]){
				result.add(i);
			}
		}

		return result;
	}

	private void dfs(List<List<Integer>> adj,int start,boolean[] visited,boolean[] articulationPoint,int[] discoveryTime,int[] lowTime,int[] parent){
		visited[start] = true;
		discoveryTime[start] = lowTime[start] = ++time;
		int children = 0;

		for (int v : adj.get(start)){
			if (!visited[v]){
				children++;
				parent[v] = start;
				dfs(adj,v,visited,articulationPoint,discoveryTime,lowTime,parent);

				lowTime[start] = Math.min(lowTime[start],lowTime[v]);

				// Root is articulation point only when it has more than one DFS child.
				if (parent[start] == -1 && children > 1){
					articulationPoint[start] = true;
				}

				// Non-root is articulation point when child subtree cannot reach an ancestor of u.
				if (parent[start] != -1 && lowTime[v] >= discoveryTime[start]){
					articulationPoint[start] = true;
				}
			} else if (v != parent[start]){
				lowTime[start] = Math.min(lowTime[start],discoveryTime[v]);
			}
		}
	}

	private void validateGraph(List<List<Integer>> adj,int vertices){
		if (vertices < 0 || adj == null || adj.size() != vertices){
			throw new IllegalArgumentException("Invalid graph input!");
		}

		for (int i = 0 ; i < vertices ; i++){
			if (adj.get(i) == null){
				throw new IllegalArgumentException("Invalid graph input!");
			}

			for (int v : adj.get(i)){
				if (v < 0 || v >= vertices){
					throw new IllegalArgumentException("Invalid vertex in graph!");
				}
			}
		}
	}

	private static void addEdge(List<List<Integer>> adj,int u,int v){
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	public static void main(String[] args) {
		int vertices = 7;
		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0 ; i < vertices ; i++){
			adj.add(new ArrayList<>());
		}

		addEdge(adj,0,1);
		addEdge(adj,1,2);
		addEdge(adj,2,0);
		addEdge(adj,1,3);
		addEdge(adj,1,4);
		addEdge(adj,1,6);
		addEdge(adj,3,5);
		addEdge(adj,4,5);

		_19ArticulationPoints articulationPoints = new _19ArticulationPoints();
		System.out.println("Articulation Points: " + articulationPoints.articulationPoints(adj,vertices));
	}
}
