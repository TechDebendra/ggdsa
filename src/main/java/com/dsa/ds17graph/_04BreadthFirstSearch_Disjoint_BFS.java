package com.dsa.ds17graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class _04BreadthFirstSearch_Disjoint_BFS {
    public void bfsDisjoint(List<List<Integer>> adj, int vertices){
        boolean[] visited = new boolean[vertices+1];
        for (int i = 0 ; i < vertices ; i++){
            if (!visited[i]){
                bfs(adj,i,visited);
            }
        }
    }

    public void bfs(List<List<Integer>> adj,int start,boolean[] visited){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;

        while (!deque.isEmpty()){
            int curr = deque.poll();
            System.out.print(curr+" ");
            for (int v : adj.get(curr)){
                if (!visited[v]){
                    deque.add(v);
                    visited[v] = true;
                }
            }
        }

    }
}
