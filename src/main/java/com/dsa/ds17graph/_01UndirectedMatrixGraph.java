package com.dsa.ds17graph;

public class _01UndirectedMatrixGraph {
    private int vertex;
    private int edges;
    private int[][] matrix;

    public _01UndirectedMatrixGraph(int vertex){
        this.vertex = vertex;
        this.edges = 0;
        this.matrix = new int[vertex][vertex];
    }

    public void addEdge(int u,int v){
        if (u < 0 || u >= vertex || v < 0 || v >= vertex){
            System.out.println("Invalid vertex.");
            return;
        }

        if (matrix[u][v] == 0){
            matrix[u][v] = 1;
            matrix[v][u] = 1;
            edges++;
        }
    }

    public void printGraph(){
        System.out.println("Adjacent graph with vertex "+vertex+" and edges "+edges);

        for (int i=0;i<vertex;i++){
            for (int j=0;j<vertex;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        _01UndirectedMatrixGraph graph = new _01UndirectedMatrixGraph(5);

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
