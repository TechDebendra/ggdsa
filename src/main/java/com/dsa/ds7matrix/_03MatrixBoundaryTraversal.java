package com.dsa.ds7matrix;

public class _03MatrixBoundaryTraversal {

    public static void main(String[] args) throws IllegalAccessException {
        int[][] matrix = {{1,2,3,4},{5,6,8,9},{10,13,14,16},{20,22,45,90}};
        print(matrix);
        boundaryTraversal(matrix);

    }

    public static void print(int[][] matrix) throws IllegalAccessException {
        if (matrix==null||matrix.length==0){
            throw new IllegalAccessException("Invalid input!");
        }
        System.out.println("Matrix :");

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void boundaryTraversal(int[][] matrix){
        System.out.println("Boundary traversal : ");
        int R=matrix.length;
        int C=matrix.length;

        if (R==1){
            for (int i=0;i<C;i++){
                System.out.print(matrix[0][i]+" ");
            }
            System.out.println();
        }else if (C==1){
            for (int i=0;i<R;i++){
                System.out.print(matrix[i][0]+" ");
            }
            System.out.println();
        }

        for (int i=0;i<C;i++){
            System.out.print(matrix[0][i]+" ");
        }
        for (int i=1;i<R;i++){
            System.out.print(matrix[i][C-1]+" ");
        }

        for (int i=C-2;i>=0;i--){
            System.out.print(matrix[R-1][i]+" ");
        }

        for (int i=R-2;i>=1;i--){
            System.out.print(matrix[i][0]+" ");
        }
        System.out.println();
    }

}
