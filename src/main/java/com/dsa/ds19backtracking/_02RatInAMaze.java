package com.dsa.ds19backtracking;

public class _02RatInAMaze {

    public static void print(int[][] solution, int N){

        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < N ; j++){
                System.out.print(solution[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean solveMaze(int[][] maze){
        int N = maze.length;
        int[][] sol = new int[N][N];

        if (solveMazeRec(maze,0,0,sol,N)){
            print(sol,N);
            return true;
        }

        System.out.println("No solution present");
        return false;
    }

    public static boolean solveMazeRec(int[][] maze,int i,int j,int[][] sol, int N){

        if (i == N-1 && j == N-1 ){
            sol[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j,N)){
            sol[i][j] = 1;

            if (solveMazeRec(maze, i+1, j, sol, N)){
                return true;
            }

            if (solveMazeRec(maze, i, j+1, sol, N)){
                return true;
            }
            sol[i][j] = 0;
        }


        return false;
    }

    public static boolean isSafe(int[][] maze,int i, int j,int N){
        return (i < N && j < N && maze[i][j] == 1);
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        solveMaze(maze);
    }
}
