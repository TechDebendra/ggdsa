package com.dsa.ds17graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class _05NoOfIslands {
    public int noOfIsland(List<List<Integer>> adj,int vertices){
        int count = 0;
        boolean[] visited = new boolean[vertices];

        for (int i=0;i<vertices;i++){
            if (!visited[i]){
                count++;
                bfs(adj,i,visited);
            }

        }
        return count;
    }

    public void bfs(List<List<Integer>> adj,int start, boolean[] visited){
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(start);
        visited[start] = true;

        while (!deque.isEmpty()){
            int curr = deque.poll();
            for (int v : adj.get(curr)){
                if (!visited[v]){
                    deque.add(v);
                    visited[v] = true;
                }
            }

        }
    }
}
