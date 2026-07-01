package com.dsa.ds8hashing;

import java.util.Arrays;
import java.util.HashSet;

public class _08SubarrayWithGivenSum {

    public static void main(String[] args) {

        test(new int[]{5,8,6,13,3,-1}, 22, true);

        test(new int[]{15,2,8,10,-5,-8,6}, 3, true);

        test(new int[]{1,4,20,3,10,5}, 33, true);

        test(new int[]{10,2,-2,-20,10}, -10, true);

        test(new int[]{1,2,3}, 7, false);

        test(new int[]{5}, 5, true);

        test(new int[]{5}, 10, false);

        test(new int[]{}, 5, false);

        test(new int[]{0}, 0, true);

        test(new int[]{1,-1,2,-2,3}, 0, true);

        test(new int[]{2,4,6,8}, 14, true);

        test(new int[]{2,4,6,8}, 5, false);

        test(new int[]{-5,-10,-3,-4}, -13, true);
    }

    public static boolean isSum(int[] arr, int sum){

        HashSet<Integer> set = new HashSet<>();

        int prefixSum = 0;

        for(int num : arr){

            prefixSum += num;

            if(prefixSum == sum){
                return true;
            }

            if(set.contains(prefixSum - sum)){
                return true;
            }

            set.add(prefixSum);
        }

        return false;
    }

    private static void test(int[] arr, int sum, boolean expected){

        boolean actual = isSum(arr, sum);

        System.out.printf(
                "Array=%-30s Sum=%4d Expected=%-5b Actual=%-5b %s%n",
                Arrays.toString(arr),
                sum,
                expected,
                actual,
                expected == actual ? "PASS" : "FAIL"
        );
    }
}