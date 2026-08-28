package com.dsa.ds17graph;

import java.util.List;

public class _11DetectCycleInDirectedGraph_DFS {

    public boolean dfs(List<List<Integer>> adj, int vertices){
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0 ; i < vertices ; i++){
            if (!visited[i]){
                if (dfsRecursion(adj,i,visited,recStack)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsRecursion(List<List<Integer>> adj, int start,boolean[] visited,boolean[] recStack){
        visited[start] = true;
        recStack[start] = true;

        for (int v : adj.get(start)){
            if (!visited[v]){
                if (dfsRecursion(adj, v, visited, recStack)){
                    return true;
                }
            } else if (recStack[v]) {
                return true;
            }
        }

        recStack[start] = false;

        return false;
    }
}
