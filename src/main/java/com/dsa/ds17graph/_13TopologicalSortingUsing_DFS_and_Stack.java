package com.dsa.ds17graph;

import java.util.List;
import java.util.Stack;

public class _13TopologicalSortingUsing_DFS_and_Stack {

    public void topologicalSort(List<List<Integer>> adj,int vertices){
        // Track vertices that are already visited
        boolean[] visited = new boolean[vertices];
        // Store vertices after finishing their DFS calls
        Stack<Integer> result = new Stack<>();

        for (int i = 0 ; i < vertices ; i++){
            if (!visited[i]){
                // Run DFS for every unvisited vertex
                dfs(adj,i,visited,result);
            }
        }

        while (!result.isEmpty()){
            // Stack gives the topological order
            System.out.printf(result.pop()+" ");
        }
    }

    public void dfs(List<List<Integer>> adj,int start,boolean[] visited,Stack<Integer> stack){
        // Mark current vertex as visited
        visited[start] = true;
        for (int v : adj.get(start)){
            if (!visited[v]){
                // Visit all unvisited neighbours first
                dfs(adj,v,visited,stack);
            }
        }
        // Add vertex after all its neighbours are processed
        stack.push(start);
    }
}
