package com.dsa.ds17graph;

import java.util.List;

public class _10DetectCycleInUndirectedGraph {
    public boolean dfs(List<List<Integer>> adj,int vertices){
        boolean[] visited = new boolean[vertices];

        for (int i =0 ; i< vertices ; i++){
            if (!visited[i]){
                if (dfsRecursion(adj,i,visited,-1)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfsRecursion(List<List<Integer>> adj,int start,boolean[] visited,int parent){
        visited[start] = true;

        for (int v : adj.get(start)){
            if (!visited[v]){
                if (dfsRecursion(adj, v, visited, start)){
                    return true;
                }
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }
}
