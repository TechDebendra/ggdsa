package com.dsa.ds17graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _15DijkstraS_AlgorithmForShortestPath {

	// Dijkstra's algorithm finds shortest paths from one source vertex.
	// It works only when all edge weights are non-negative.
	public int[] dijkstra(List<List<Edge>> adj,int source,int vertices){

		if (adj == null || vertices <= 0 || adj.size() != vertices || source < 0 || source >= vertices){
			throw new IllegalArgumentException("Invalid graph input!");
		}

		// distance[i] stores shortest known distance from source to vertex i
		int[] distance = new int[vertices];
		// Integer.MAX_VALUE means the vertex is not reachable yet
		Arrays.fill(distance,Integer.MAX_VALUE);

		// true means shortest distance of this vertex is already finalized
		boolean[] visited = new boolean[vertices];

		// Min heap gives the next vertex with smallest known distance
		PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
		distance[source] = 0;
		// Start from source with distance 0
		minHeap.add(new Edge(source,0));

		while (!minHeap.isEmpty()){
			// Current edge stores vertex and its shortest known distance
			Edge curr = minHeap.poll();

			if (visited[curr.vertex]){
				// Skip old heap entries for already finalized vertices
				continue;
			}

			// Once picked by min heap, this distance is final
			visited[curr.vertex] = true;

			for (Edge edge : adj.get(curr.vertex)){
				if (edge.vertex < 0 || edge.vertex >= vertices || edge.weight < 0){
					throw new IllegalArgumentException("Invalid edge input!");
				}

				// Avoid int overflow before adding distance and edge weight
				if (distance[curr.vertex] > Integer.MAX_VALUE - edge.weight){
					throw new ArithmeticException("Shortest path distance is too large!");
				}

				// Relaxation: check if curr -> edge.vertex gives a shorter path
				int newDistance = distance[curr.vertex] + edge.weight;
				if (!visited[edge.vertex] && newDistance < distance[edge.vertex]){
					distance[edge.vertex] = newDistance;
					// Add updated distance to heap for future processing
					minHeap.add(new Edge(edge.vertex,newDistance));
				}
			}
		}

		return distance;
	}



}
