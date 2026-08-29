package com.dsa.ds17graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class _09ShortestPathInUnweightedGraph_BFS {

    public int[] shortestPath(List<List<Integer>> adj, int start,int vertices){
        int[] path = new int[vertices];
        Arrays.fill(path,-1);

        boolean[] visited = new boolean[vertices];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        path[start] = 0;
        visited[start] = true;

        while (!queue.isEmpty()){
            int curr = queue.poll();
            for (int v : adj.get(curr)){
                if (!visited[v]){
                    queue.add(v);
                    visited[v] = true;
                    path[v] = path[curr]+1;
                }
            }

        }

        return path;
    }
}
