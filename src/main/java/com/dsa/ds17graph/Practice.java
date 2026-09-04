package com.dsa.ds17graph;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class Practice {
    static class Graph{
        int vertices;
        int edges;
       List<List<Integer>> adj;

        public Graph(int vertices){
            this.vertices = vertices;
            this.edges = 0;
            this.adj = new ArrayList<>(vertices);

            for (int i = 0 ; i < vertices ; i++){
                this.adj.add(new ArrayList<>());
            }
        }
        public void add(int u,int v){
            if (u < 0 || v < 0 || u >=vertices || v >= vertices){
                throw new IllegalArgumentException("Invalid input!");
            }

            if (!adj.get(u).contains(v)){
                edges++;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
        public void display() {
            System.out.println("Edges : " + edges);
            System.out.println("Vertices : " + vertices);

            for (int i = 0; i < adj.size(); i++) {
                System.out.print(i + " --> ");

                for (int neighbour : adj.get(i)) {
                    System.out.print(neighbour + " ");
                }

                System.out.println();
            }
        }
        public void bfs(){
            boolean[] visited = new boolean[vertices];

            int count = 0;

            for (int i =0 ; i < vertices ; i++){
                if (!visited[i]){
                    count++;
                    System.out.println("\nComponent : "+count);
                    bfsUtils(i,visited);
                }
            }

            System.out.println("\nNo of connected components : "+count);
        }
        public void bfsUtils(int start, boolean[] visited){
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            visited[start] = true;

            while (!queue.isEmpty()){
                int curr = queue.poll();

                System.out.print(curr + " ");
                for (int u : adj.get(curr)){
                    if (!visited[u]){
                        queue.offer(u);
                        visited[u] = true;
                    }
                }
            }

        }
        public void dfs(){

            boolean[] visited = new boolean[vertices];

            for (int i = 0 ; i < vertices ; i++){
                if (!visited[i]){
                    dfsRec(i,visited);
                }
            }
        }
        public void dfsRec(int start,boolean[] visited){

            System.out.print(start+" ");
            visited[start] = true;

            for (int u : adj.get(start)){
                if (!visited[u]){
                    dfsRec(u,visited);
                }
            }

        }
        public void dfsUsingStack(){
            boolean[] visited = new boolean[vertices];
            for (int i = 0 ; i < vertices ; i ++){
                if (!visited[i]){
                    dfsUsingStackUtils(i,visited);
                }
            }

        }
        public void dfsUsingStackUtils(int start,boolean[] visited){

            Deque<Integer> stack = new ArrayDeque<>();

            stack.push(start);

            while (!stack.isEmpty()){
                int curr = stack.pop();
                if (!visited[curr]){
                    System.out.print(curr+" ");
                    visited[curr] = true;

                    for (int i = adj.get(curr).size()-1 ; i >= 0 ; i--){
                        int neighbour = adj.get(curr).get(i);
                        if (!visited[neighbour]){
                            stack.push(neighbour);
                        }
                    }
                }
            }
        }
        public int[] shortestPath(int source){
            boolean[] visited = new boolean[vertices];
            int[] path = new int[vertices];
            Arrays.fill(path,Integer.MAX_VALUE);

            pathUtils(source,visited,path);

            return path;
        }
        public void pathUtils(int start,boolean[] visited,int[] path){

            Deque<Integer> queue = new ArrayDeque<>();
            visited[start] = true;
            path[start] = 0;
            queue.offer(start);

            while (!queue.isEmpty()){
                int curr = queue.poll();
                for (int u : adj.get(curr)){
                    if (!visited[u]){
                        visited[u] = true;
                        queue.offer(u);
                        path[u] = path[curr]+1;
                    }
                }
            }
        }
        public boolean isCycleDetectedInUndirectedGraph(){
            boolean[] visited = new boolean[vertices];

            for (int i = 0 ; i < vertices ; i++){
                if (!visited[i] && cycleDetectedInUndirectedGraphUtils(i,visited,-1)){
                    return true;
                }
            }

            return false;
        }
        public boolean cycleDetectedInUndirectedGraphUtils(int start,boolean[] visited,int parent){
            visited[start] = true;

            for (int u : adj.get(start)){
                if (!visited[u]){
                    if (cycleDetectedInUndirectedGraphUtils(u,visited,start)){
                        return true;
                    }

                } else if (u != parent) {
                    return true;
                }
            }

            return false;

        }
        public boolean isCyclicDetectedInDirectedGraph(){
            boolean[] visited = new boolean[vertices];
            boolean[] recStack = new boolean[vertices];

            for (int i = 0 ; i < vertices ; i++){
                if (cycleDetectedInDirectedGraphUtils(i,visited,recStack)){
                    return true;
                }
            }

            return false;
        }

        public boolean cycleDetectedInDirectedGraphUtils(int start, boolean[] visited,boolean[] recStack){
            visited[start] = true;
            recStack[start] = true;

            for (int u : adj.get(start)){
                if (!visited[u]){
                    if (cycleDetectedInDirectedGraphUtils(u,visited,recStack)){
                        return true;
                    }
                } else if (recStack[u]) {
                    return true;
                }
            }

            return false;
        }










    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.add(0,1);
        graph.display();
        graph.add(0,1);
        graph.display();

        graph.add(1, 2);
        graph.add(1, 3);
        graph.add(1, 4);
        graph.add(2, 3);
        graph.add(3, 4);
        graph.add(6,7);
        graph.display();

        System.out.println("BFS : ");
        graph.bfs();

        System.out.println("DFS : ");
        graph.dfs();

        System.out.println("\nDFS using stack :");
        graph.dfsUsingStack();

        int[] path = graph.shortestPath(0);
        System.out.println("\nShortest path array  from vertex 0 : "+Arrays.toString(path));





    }
}
