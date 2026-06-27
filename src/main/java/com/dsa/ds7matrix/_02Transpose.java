package com.dsa.ds7matrix;

public class _02Transpose {
    public static void main(String[] args) throws IllegalAccessException {
        int[][] matrix = {{1,2,3,4},{5,6,8,9},{10,13,14,16},{20,22,45,90}};
        System.out.println("Matrix :");
        print(matrix);
        transpose(matrix);
        System.out.println("Transpose :");
        print(matrix);

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

    public static void transpose(int[][] matrix){

        for (int i=0;i<matrix.length;i++){
            for (int j=i+1;j<matrix[i].length;j++){
                 swap(matrix,i,j);
            }
        }

    }

    public static void swap(int[][] matrix,int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

}
