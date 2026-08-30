package com.dsa.ds17graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _20BridgesInAGraph {

	private int time;

	// Bridge/cut edge: removing this edge increases the number of connected components.
	// Time Complexity: O(V + E), Space Complexity: O(V)
	public List<List<Integer>> bridges(List<List<Integer>> adj,int vertices){
		validateGraph(adj,vertices);

		boolean[] visited = new boolean[vertices];
		int[] discoveryTime = new int[vertices];
		int[] lowTime = new int[vertices];
		int[] parent = new int[vertices];
		List<List<Integer>> result = new ArrayList<>();

		Arrays.fill(parent,-1);
		time = 0;

		// Run DFS from every unvisited vertex to handle disconnected graphs too.
		for (int i = 0 ; i < vertices ; i++){
			if (!visited[i]){
				dfs(adj,i,visited,discoveryTime,lowTime,parent,result);
			}
		}

		return result;
	}

	private void dfs(List<List<Integer>> adj,int start,boolean[] visited,int[] discoveryTime,int[] lowTime,int[] parent,List<List<Integer>> result){
		visited[start] = true;
		discoveryTime[start] = lowTime[start] = ++time;
		boolean parentEdgeSkipped = false;

		for (int v : adj.get(start)){
			if (v == parent[start] && !parentEdgeSkipped){
				// Skip only the tree edge that brought us here. Any parallel edge to parent is a back edge.
				parentEdgeSkipped = true;
				continue;
			}

			if (!visited[v]){
				parent[v] = start;
				dfs(adj,v,visited,discoveryTime,lowTime,parent,result);

				lowTime[start] = Math.min(lowTime[start],lowTime[v]);

				// If v's subtree cannot reach start or any ancestor of start, then start-v is a bridge.
				if (lowTime[v] > discoveryTime[start]){
					result.add(Arrays.asList(Math.min(start,v),Math.max(start,v)));
				}
			} else {
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

		_20BridgesInAGraph bridgesInAGraph = new _20BridgesInAGraph();
		System.out.println("Bridges: " + bridgesInAGraph.bridges(adj,vertices));
	}
}
