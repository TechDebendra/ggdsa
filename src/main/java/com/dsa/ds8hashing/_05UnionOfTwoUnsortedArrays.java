package com.dsa.ds8hashing;

import java.util.HashSet;

public class _05UnionOfTwoUnsortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {10, 15, 20, 15, 30, 30, 5};
        int[] arr2 = {30, 5, 30, 80};

        union(arr1, arr2);

    }

    public static void union(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();

        for (int i: arr1){
            set.add(i);
        }

        for (int j : arr2){
            set.add(j);
        }

        System.out.println(set);
    }
}
