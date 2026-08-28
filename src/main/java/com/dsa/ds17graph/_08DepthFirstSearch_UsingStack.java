package com.dsa.ds17graph;

import java.util.List;
import java.util.Stack;

public class _08DepthFirstSearch_UsingStack {
    public void dfs(List<List<Integer>> adj, int vertices, int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");

                // Push neighbors in reverse order
                for (int i = adj.get(current).size() - 1; i >= 0; i--) {
                    int neighbour = adj.get(current).get(i);
                    if (!visited[neighbour]) {
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

}
