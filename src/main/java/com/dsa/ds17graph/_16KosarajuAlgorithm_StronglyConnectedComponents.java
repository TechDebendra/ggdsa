package com.dsa.ds17graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _16KosarajuAlgorithm_StronglyConnectedComponents {

	// Returns only the number of strongly connected components.
	public int kosaraju(List<List<Integer>> adj,int vertices){
		return stronglyConnectedComponents(adj,vertices).size();
	}

	// Kosaraju's algorithm finds groups where every vertex can reach every other vertex.
	// Step 1: DFS and store vertices by finish time.
	// Step 2: Reverse all edges.
	// Step 3: DFS in finish-time order on reversed graph.
	public List<List<Integer>> stronglyConnectedComponents(List<List<Integer>> adj,int vertices){
		if (adj == null || vertices <= 0 || adj.size() != vertices){
			throw new IllegalArgumentException("Invalid graph input!");
		}

		// First DFS pass uses this visited array
		boolean[] visited = new boolean[vertices];
		// Vertices with later finish time stay on top
		Stack<Integer> stack = new Stack<>();

		for (int i = 0 ; i < vertices ; i++){
			if (!visited[i]){
				// DFS may cover one full reachable part of the graph
				fillStackByFinishTime(adj,i,visited,stack,vertices);
			}
		}

		// Reversing edges helps separate SCCs in the second DFS pass
		List<List<Integer>> transpose = getTranspose(adj,vertices);

		// Reset visited for DFS on reversed graph
		visited = new boolean[vertices];
		List<List<Integer>> result = new ArrayList<>();

		while (!stack.isEmpty()){
			// Process highest finish-time vertex first
			int curr = stack.pop();

			if (!visited[curr]){
				List<Integer> component = new ArrayList<>();
				// All vertices reached here belong to the same SCC
				collectComponent(transpose,curr,visited,component);
				result.add(component);
			}
		}

		return result;
	}

	private void fillStackByFinishTime(List<List<Integer>> adj,int start,boolean[] visited,Stack<Integer> stack,int vertices){
		visited[start] = true;

		for (int v : adj.get(start)){
			if (v < 0 || v >= vertices){
				throw new IllegalArgumentException("Invalid edge input!");
			}

			if (!visited[v]){
				// Visit neighbour before pushing current vertex
				fillStackByFinishTime(adj,v,visited,stack,vertices);
			}
		}

		// Push only after all outgoing paths are completed
		stack.push(start);
	}

	private List<List<Integer>> getTranspose(List<List<Integer>> adj,int vertices){
		// Transpose graph stores every edge in reverse direction
		List<List<Integer>> transpose = new ArrayList<>();

		for (int i = 0 ; i < vertices ; i++){
			transpose.add(new ArrayList<>());
		}

		for (int i = 0 ; i < vertices ; i++){
			for (int v : adj.get(i)){
				if (v < 0 || v >= vertices){
					throw new IllegalArgumentException("Invalid edge input!");
				}

				// Reverse edge i -> v into v -> i
				transpose.get(v).add(i);
			}
		}

		return transpose;
	}

	private void collectComponent(List<List<Integer>> adj,int start,boolean[] visited,List<Integer> component){
		// Add current vertex to current SCC
		visited[start] = true;
		component.add(start);

		for (int v : adj.get(start)){
			if (!visited[v]){
				// Keep collecting connected vertices in reversed graph
				collectComponent(adj,v,visited,component);
			}
		}
	}
}
