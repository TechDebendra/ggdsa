package com.dsa.ds5searching;

public class _16AllocateMinimumPages_Simple {

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40};
        System.out.println(minPages(arr1,  2)); // 60

        int[] arr2 = {10, 20, 30};
        System.out.println(minPages(arr2,   2)); // 30

        int[] arr3 = {10, 5, 30, 1, 2, 5, 10, 10};
        System.out.println(minPages(arr3,   3)); // 30
    }

    public static int minPages(int[] books, int students){
        if (books ==  null || books.length == 0){
            return -1;
        }

        if (students > books.length){
            return -1;
        }

        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int book : books){
            low = Math.max(low,book);
            high += book;
        }

        int result = high;

        while (low <= high){
            int mid = low + (high-low)/2;
            if (isPossible(books,students,mid)){
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int[] books,int students,int maxPages){
        int requiredStudents = 1;
        int currentPages = 0;

        for (int book : books){
             if (currentPages + book <= maxPages){
                 currentPages += book;
             }else {
                 requiredStudents++;
                 currentPages = book;
                 if (requiredStudents > students){
                     return false;
                 }
             }
        }

        return true;
    }

}
