package com.dsa.ds17graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _14PrimMinimumSpanningTreeAlgorithm {

	// Prim's algorithm finds the minimum cost tree that connects all vertices.
	// It always expands the MST using the smallest available edge.
	public int primMST(List<List<Edge>> adj,int vertices){
		if (adj == null || vertices <= 0 || adj.size() != vertices){
			throw new IllegalArgumentException("MST cannot be formed because the graph is disconnected!");
		}

		// true means this vertex is already part of the MST
		boolean[] mstSet = new boolean[vertices];

		// Min heap keeps the smallest edge at the top
		PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
		// Start from vertex 0 with cost 0
		minHeap.add(new Edge(0,0));

		// Total weight of all edges selected in MST
		int totalWeight = 0;
		// Used to check whether all vertices were connected
		int visitedVertices = 0;

		while (!minHeap.isEmpty()){
			// Get the cheapest edge available now
			Edge curr = minHeap.poll();

			if (mstSet[curr.vertex]){
				continue;
			}

			// Add current vertex and its edge cost to MST
			mstSet[curr.vertex] = true;
			totalWeight += curr.weight;
			visitedVertices++;

			for (Edge edge : adj.get(curr.vertex)){
				// Push edges going to vertices outside MST
				if (!mstSet[edge.vertex]){
					minHeap.add(edge);
				}
			}
		}

		if (visitedVertices != vertices){
			// MST is not possible if some vertex cannot be reached
			throw new IllegalArgumentException("Graph is disconnected!");
		}

		return totalWeight;
	}

}
