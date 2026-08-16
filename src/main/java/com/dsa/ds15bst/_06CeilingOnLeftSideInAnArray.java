package com.dsa.ds15bst;

import java.util.TreeSet;

public class _06CeilingOnLeftSideInAnArray {
    public static void main(String[] args) {
        int[] input = {2,8,30,15,25,12};
        displayLeftSideCeiling(input);
        System.out.println("\nOptimised ");
        displayLeftSideCeilingOptimised(input);
    }

    public static void displayLeftSideCeiling(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        System.out.print("-1 ");
        for (int i=1;i<arr.length;i++){
            int ceil=Integer.MAX_VALUE;

            for (int j=0;j<i;j++){
                if (arr[j]>=arr[i] && arr[j]<ceil){
                    ceil = arr[j];
                }
            }

            if (ceil == Integer.MAX_VALUE){
                System.out.print("-1 ");
            }else {
                System.out.print(ceil+" ");
            }
        }
    }

    public static void displayLeftSideCeilingOptimised(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        System.out.println();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr){
            Integer ceil = set.higher(i);
            if (ceil == null){
                System.out.print("-1 ");
            }else {
                System.out.print(ceil+" ");
            }
            set.add(i);
        }
    }
}
