package com.dsa.ds17graph;

import java.util.List;

public class _07DepthFirstSearch_Disjoint_DFS {

    public void dfs(List<List<Integer>> adj,int vertices){
        boolean[] visited = new boolean[vertices];

        for (int i = 0 ; i < vertices ; i++){
            if (!visited[i]){
                dfsRecursive(adj,i,visited);
            }
        }
    }

    public void dfsRecursive(List<List<Integer>> adj, int start, boolean[] visited){
        System.out.print(start+" ");
        visited[start] = true;
        for (int v : adj.get(start)){
            if (!visited[v]){
                dfsRecursive(adj, v, visited);
            }
        }
    }
}
