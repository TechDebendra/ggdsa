package com.dsa.ds19backtracking;

/**
 * Solves a Sudoku puzzle using backtracking.
 *
 * <p>Empty cells are represented by {@code 0}. The algorithm finds the next
 * empty cell, tries every possible value from {@code 1} to {@code N}, and
 * recursively continues only when the value does not violate Sudoku rules.</p>
 */
public class _04SudokuProblem {


    public static void printBoard(int[][] board){
        int N = board.length;
        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < N ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static boolean solveSudoku(int[][] board,int N){
        int i = 0,j = 0;
        boolean isEmptyCellFound = false;

        // Find the first empty cell in row-major order.
        for (i = 0 ; i < N ; i++){
            for (j = 0 ; j < N ; j++){
                if (board[i][j] ==  0){
                    isEmptyCellFound = true;
                    break;
                }
            }
            if (isEmptyCellFound){
                break;
            }
        }

        // No empty cell remains, so the board is completely solved.
        if (i == N){
            return true;
        }

        // Try every possible value for the selected empty cell.
        for (int x =1 ; x <=N ; x++){
            if (isSafe(i,j,x,board,N)){
                board[i][j] = x;

                // Recursively solve the remaining board after this placement.
                if (solveSudoku(board, N)){
                    return true;
                }

                // Backtrack when the current placement does not lead to a solution.
                board[i][j] = 0;
            }
        }

        return false;
    }

    public static boolean isSafe( int i, int j, int x,int[][] board,int N){
        // Check whether the value already exists in the same row or column.
        for (int k =0 ; k < N ; k++){
            if (board[i][k] == x || board[k][j] == x){
                return false;
            }
        }

        // Locate the top-left cell of the sub-square containing board[i][j].
        int subSqare = (int) Math.sqrt(N);
        int subSqareRow = i - i%subSqare;
        int subSqareCol = j - j%subSqare;

        // Check whether the value already exists in the same sub-square.
        for (i =0 ; i < subSqare ; i++){
            for (j=0 ; j < subSqare; j++){
                if (board[i+subSqareRow][j+subSqareCol] == x){
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if (solveSudoku(grid, grid.length))
            printBoard(grid);
        else
            System.out.println("No Solution exists");
    }
}
