package com.dsa.ds7matrix;

public class _01SnakePattern {
    public static void main(String[] args) throws IllegalAccessException {
        int[][] matrix = {{1,2,3,4},{5,6,8,9},{10,13,14,16},{20,22,45,90}};

        System.out.println("Matrix :");
        print(matrix);
        snakePattern(matrix);

    }

    public static void print(int[][] matrix) throws IllegalAccessException {
        if (matrix==null||matrix.length==0){
            throw new IllegalAccessException("Invalid input!");
        }


        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void snakePattern(int[][] matrix) throws IllegalAccessException {
        if (matrix==null||matrix.length==0){
            throw new IllegalAccessException("Invalid input!");
        }

        System.out.println("Snake Pattern");
        for (int i=0;i<matrix.length;i++){
            if (i%2==0){
                for (int j=0;j<matrix[i].length;j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }else {
                for (int k=matrix.length-1;k>=0;k--){
                    System.out.print(matrix[i][k]+" ");
                }
                System.out.println();
            }
        }

    }


}
