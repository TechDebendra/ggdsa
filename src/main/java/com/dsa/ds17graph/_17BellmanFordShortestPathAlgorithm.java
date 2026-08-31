package com.dsa.ds17graph;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class _17BellmanFordShortestPathAlgorithm {

	// Bellman-Ford finds shortest paths from one source vertex.
	// It can handle negative edge weights, unlike Dijkstra's algorithm.
	public int[] bellmanFord(List<List<Edge>> adj,int source,int vertices){

		if (adj == null || vertices <= 0 || adj.size() != vertices || source < 0 || source >= vertices){
			throw new IllegalArgumentException("Invalid graph input!");
		}

		// distance[i] stores shortest known distance from source to vertex i
		int[] distance = new int[vertices];
		// Integer.MAX_VALUE means the vertex is not reachable yet
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[source] = 0;

		// Repeat relaxation V-1 times because a shortest path can have at most V-1 edges
		for (int count = 1 ; count < vertices ; count++){
			// Used to stop early if no distance changes in this round
			boolean updated = false;

			for (int u = 0 ; u < vertices ; u++){
				if (distance[u] == Integer.MAX_VALUE){
					// Skip vertices not reachable from source yet
					continue;
				}

				for (Edge edge : adj.get(u)){
					validateEdge(edge,vertices);

					// Relaxation: try to improve distance using edge u -> edge.vertex
					int newDistance = distance[u] + edge.weight;
					if (newDistance < distance[edge.vertex]){
						distance[edge.vertex] = newDistance;
						updated = true;
					}
				}
			}

			if (!updated){
				// No update means all shortest distances are already found
				break;
			}
		}

		// After V-1 relaxations, perform one additional pass over all edges.
		// If any edge can still be relaxed, a reachable negative weight cycle exists.
		for (int u = 0 ; u < vertices ; u++){
			if (distance[u] == Integer.MAX_VALUE){
				continue;
			}

			for (Edge edge : adj.get(u)){
				validateEdge(edge,vertices);

				// If distance can still improve now, a negative cycle is reachable
				int newDistance = distance[u] + edge.weight;
				if (newDistance < distance[edge.vertex]){
					throw new IllegalStateException(
							"Graph contains negative weight cycle!");
				}
			}
		}

		return distance;
	}

	private void validateEdge(Edge edge,int vertices){
		// Bellman-Ford allows negative weight, but vertex index must be valid
		if (edge == null || edge.vertex < 0 || edge.vertex >= vertices){
			throw new IllegalArgumentException("Invalid edge input!");
		}
	}

}
