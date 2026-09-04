package com.dsa.ds17graph;

import java.util.*;

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

    // Without visited array
    public int[] shortestPath1(List<List<Integer>> adj,int start,int vertices){
        int[] path = new int[vertices];
        Arrays.fill(path,Integer.MAX_VALUE);

        Deque<Integer> queue = new ArrayDeque<>();
        path[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()){
            int curr = queue.poll();
            for (int u : adj.get(curr)){
                if (path[u] == Integer.MAX_VALUE){
                    path[u] = path[curr]+1;
                    queue.offer(u);
                }
            }
        }
        return path;
    }
}
