package com.dsa.ds8hashing;

import java.util.HashMap;

public class _09LongestSubarrayWithGivenSum {

    public static void main(String[] args) {

        test(new int[]{5,8,-4,-4,9,-2,2},0,3);

        test(new int[]{8,3,1,5,-6,6,2,2},4,5);

        test(new int[]{3,1,0,1,8,2,3,6},5,4);

        test(new int[]{1,2,3},6,3);

        test(new int[]{1,2,3},7,0);

        test(new int[]{10,-10,10,-10},0,4);

        test(new int[]{5},5,1);

        test(new int[]{5},10,0);

        test(new int[]{},0,0);

        test(new int[]{-1,-1,1,1},0,4);
    }

    public static int longestSubarray(int[] arr, int sum){

        int res = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        int prefixSum = 0;

        for(int i = 0; i < arr.length; i++){

            prefixSum += arr[i];

            if(prefixSum == sum){
                res = i + 1;
            }

            map.putIfAbsent(prefixSum, i);

            if(map.containsKey(prefixSum - sum)){
                res = Math.max(res, i - map.get(prefixSum - sum));
            }
        }

        return res;
    }

    private static void test(int[] arr,int sum,int expected){

        int actual = longestSubarray(arr,sum);

        System.out.printf(
                "Array=%-35s Sum=%3d Expected=%2d Actual=%2d %s%n",
                java.util.Arrays.toString(arr),
                sum,
                expected,
                actual,
                expected==actual ? "PASS" : "FAIL"
        );
    }
}