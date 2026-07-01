package com.dsa.ds8hashing;

import java.util.HashSet;

public class _04IntersectionOfTwoUnsortedArray {
    public static void main(String[] args) {
        int[] arr1 = {10, 15, 20, 15, 30, 30, 5};
        int[] arr2 = {30, 5, 30, 80};

        intersection(arr1, arr2);

    }

    public static void intersection(int[] arr1, int[] arr2){
         HashSet<Integer> set = new HashSet<>();

         for (int i : arr2){
             set.add(i);
         }

         for (int j : arr1){
             if (set.contains(j)){
                 System.out.println(j);
                 set.remove(j); // to prevent duplicate
             }
         }
    }
}
