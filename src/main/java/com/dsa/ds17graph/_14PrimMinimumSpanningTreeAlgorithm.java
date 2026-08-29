package com.dsa.ds17graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _14PrimMinimumSpanningTreeAlgorithm {

	public int primMST(List<List<Edge>> adj,int vertices){
		if (adj == null || vertices <= 0 || adj.size() != vertices){
			throw new IllegalArgumentException("MST cannot be formed because the graph is disconnected!");
		}

		// Track vertices already added to MST
		boolean[] mstSet = new boolean[vertices];

		// Pick the edge with minimum weight first
		PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
		minHeap.add(new Edge(0,0));

		int totalWeight = 0;
		int visitedVertices = 0;

		while (!minHeap.isEmpty()){
			Edge curr = minHeap.poll();

			if (mstSet[curr.vertex]){
				continue;
			}

			// Add current vertex to MST
			mstSet[curr.vertex] = true;
			totalWeight += curr.weight;
			visitedVertices++;

			for (Edge edge : adj.get(curr.vertex)){
				// Add only neighbours that are not already in MST
				if (!mstSet[edge.vertex]){
					minHeap.add(edge);
				}
			}
		}

		if (visitedVertices != vertices){
			throw new IllegalArgumentException("Graph is disconnected!");
		}

		return totalWeight;
	}

}
