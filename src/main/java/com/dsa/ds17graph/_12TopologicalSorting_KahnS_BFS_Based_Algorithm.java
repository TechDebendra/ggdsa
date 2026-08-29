package com.dsa.ds17graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _12TopologicalSorting_KahnS_BFS_Based_Algorithm {
    public void topologicalSorting(List<List<Integer>> adj,int vertices){
        // Store incoming edge count for each vertex
        int[] inDegree = new int[vertices];

        for (int i = 0 ; i < vertices ; i++){
            for (int v : adj.get(i)){
                // One edge is coming into vertex v
                inDegree[v]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i =0 ; i < inDegree.length ; i++){
            if (inDegree[i]==0){
                // Start with vertices having no incoming edges
                queue.add(i);
            }
        }

        int visitedVertices = 0;
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
            // Pick the next vertex with zero in-degree
            int curr = queue.poll();
            result.add(curr);
            visitedVertices++;

            for (int v : adj.get(curr)){
                // Remove current vertex's edge from its neighbours
                if (--inDegree[v] == 0){
                    // Add neighbour when all its incoming edges are removed
                    queue.add(v);
                }
            }
        }

        if (visitedVertices != vertices){
            // If not all vertices are visited, graph has a cycle
            System.out.println("There is a cyclic exist!");
            return;
        }
        System.out.println(result);

    }
}
