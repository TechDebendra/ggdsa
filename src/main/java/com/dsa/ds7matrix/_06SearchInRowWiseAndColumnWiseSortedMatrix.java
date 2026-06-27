package com.dsa.ds7matrix;

public class _06SearchInRowWiseAndColumnWiseSortedMatrix {
    public static void main(String[] args) throws IllegalAccessException {
        int[][] matrix = {      {1,2,3,4},
                                {5,6,8,9},
                                {10,13,14,16},
                                {20,22,45,90}
                        };

        System.out.println("Matrix :");
        print(matrix);
        search(matrix,14);
        search(matrix,0);

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

    public static void search(int[][] matrix,int k){
        if (matrix == null ||
                matrix.length == 0 ||
                matrix[0].length == 0) {

            System.out.println("Invalid Matrix");
            return;
        }

        int R=matrix.length;
        int C=matrix[0].length;

        int r=0;
        int c=C-1;

        while (r<R && c>=0){
            if (matrix[r][c]==k){
                System.out.println(k+" found at row : "+r+" column : "+c);
                return;
            }else if (matrix[r][c]<k){
                r++;
            }else {
                c--;
            }

        }


        System.out.println(k+" not found.");
    }
}
