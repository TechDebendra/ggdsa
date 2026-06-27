package com.dsa.ds7matrix;

public class _04MatrixRotation {
    public static void main(String[] args) throws IllegalAccessException {
        int[][] matrix = {{1,2,3,4},{5,6,8,9},{10,13,14,16},{20,22,45,90}};
        System.out.println("Matrix :");
        print(matrix);
        rotate(matrix);

        System.out.println("Matrix after roration :");
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


    public static void rotate(int[][] matrix){

        int R=matrix.length;
        int C=matrix[0].length;

        for (int i=0;i<R;i++){
            for (int j=i+1;j<C;j++){
                swap(matrix,i,j);
            }
        }

        for (int i=0;i<C;i++){
            int low=0;
            int high=R-1;
            while (low<high){
                int temp=matrix[low][i];
                matrix[low][i]=matrix[high][i];
                matrix[high][i]=temp;
               low++;
               high--;
            }
        }

    }
    public static void swap(int[][] matrix,int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }



}
