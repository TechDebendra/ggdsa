package com.dsa.ds17graph;

import java.util.List;

public class _06DepthFirstSearch_DFS {

    public void dfs(List<List<Integer>> adj,int vertices,int start){
        boolean[] visited = new boolean[vertices];
        dfsRecursive(adj,start,visited);
    }

    public void dfsRecursive(List<List<Integer>> adj, int start,boolean[] visited){

        visited[start] = true;
        System.out.print(start+" ");

        for (int v : adj.get(start)){
            if (!visited[v]){
                dfsRecursive(adj, v, visited);
            }
        }

    }
}
