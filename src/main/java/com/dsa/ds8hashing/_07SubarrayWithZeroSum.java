package com.dsa.ds8hashing;

import java.util.Arrays;
import java.util.HashSet;

public class _07SubarrayWithZeroSum {

    public static void main(String[] args) {

        test(new int[]{4,2,-3,1,6}, true);

        test(new int[]{4,2,0,1,6}, true);

        test(new int[]{-3,2,3,1,6}, false);

        test(new int[]{5,-5}, true);

        test(new int[]{1,2,3}, false);

        test(new int[]{0}, true);

        test(new int[]{1}, false);

        test(new int[]{}, false);

        test(new int[]{1,-1}, true);

        test(new int[]{3,4,-7,5,-6,2}, true);

        test(new int[]{2,-2,3,-3,4}, true);

        test(new int[]{10,-10,20,-20}, true);

        test(new int[]{1,2,-1,-2,5}, true);

        test(new int[]{7,8,9}, false);
    }

    public static boolean isZeroSubarray(int[] arr){

        HashSet<Integer> sumSet = new HashSet<>();

        int prefixSum = 0;

        for(int num : arr){

            prefixSum += num;

            if(prefixSum == 0 || sumSet.contains(prefixSum)){
                return true;
            }

            sumSet.add(prefixSum);
        }

        return false;
    }

    private static void test(int[] arr, boolean expected){

        boolean actual = isZeroSubarray(arr);

        System.out.printf(
                "Array=%-30s Expected=%-5b Actual=%-5b %s%n",
                Arrays.toString(arr),
                expected,
                actual,
                expected == actual ? "PASS" : "FAIL"
        );
    }
}