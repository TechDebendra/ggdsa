package com.dsa.ds19backtracking;

public class _03NQueenProblem {

    public static int N = 4;
    public static int[][] board = new int[N][N];

    public static void printBoard(){
        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < N ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int row, int col){
        int i,j;

        for (i =  0 ; i < col ; i++){
            if (board[row][i]==1){
                return false;
            }
        }

        for (i = row,j=col; i >= 0 && j>=0; i--,j--){
            if (board[i][j] == 1){
                return false;
            }
        }

        for (i = row,j=col;i<N && j>=0;i++,j--){
            if (board[i][j]==1){
                return false;
            }
        }

        return true;
    }

    public static boolean solveRec(int col){
        if (col == N){
            return true;
        }

        for (int i = 0 ; i < N ; i++){
            if (isSafe(i,col)){
                board[i][col] = 1;
                if (solveRec(col+1)){
                    return true;
                }
                board[i][col] = 0;
            }
        }

        return false;
    }


    public static boolean solve(){
        if (!solveRec(0)){
            System.out.println("No solution exist!");
            return false;
        }

        printBoard();
        return true;
    }

    public static void main(String[] args) {
        solve();
    }
}
