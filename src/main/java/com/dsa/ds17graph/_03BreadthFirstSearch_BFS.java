package com.dsa.ds17graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class _03BreadthFirstSearch_BFS {

    public void bfs(List<List<Integer>> adj, int vertex, int start){
        boolean[] visited = new boolean[vertex+1];
        Deque<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int curr = queue.poll();
            System.out.print(curr+" ");
            for (int v : adj.get(curr)){
                if (!visited[v]){
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}
