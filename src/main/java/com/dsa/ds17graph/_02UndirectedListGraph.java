package com.dsa.ds17graph;

import java.util.ArrayList;
import java.util.List;

public class _02UndirectedListGraph {
    private final int vertices;
    private int edges;
    private List<List<Integer>> lists;

    _02UndirectedListGraph(int vertices){
        this.vertices = vertices;
        this.edges = 0;
        this.lists = new ArrayList<>();
        for (int i = 0 ;i < vertices ; i++){
            lists.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        if (u < 0 || u >= vertices || v < 0 || v >= vertices){
            System.out.println("Invalid vertex.");
            return;
        }

        if (!lists.get(u).contains(v)){
            lists.get(u).add(v);
            lists.get(v).add(u);
            edges++;
        }
    }

    public void printGraph(){
        System.out.println("Vertices: " + vertices);
        System.out.println("Edges: " + edges);
        for (int i=0 ; i< vertices; i++){
            System.out.print(i + " -> ");
            for (int neighbour : lists.get(i)){
                System.out.print(neighbour+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        _02UndirectedListGraph graph = new _02UndirectedListGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();

    }

}
