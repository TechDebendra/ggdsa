package com.dsa.ds8hashing;

import java.util.HashMap;

public class _10LongestSubArrayWithEqualsNoZeroAndOne {
    public static void main(String[] args) {

        test(new int[]{1,0,1,1,1,0,0},6);

        test(new int[]{1,1,1,1},0);

        test(new int[]{0,0,0},0);

        test(new int[]{0,1},2);

        test(new int[]{1,0},2);

        test(new int[]{1,0,0,1},4);

        test(new int[]{1,1,0,0},4);

        test(new int[]{0,1,1,0,1,0},6);

        test(new int[]{0},0);

        test(new int[]{1},0);

        test(new int[]{},0);
    }

    private static void test(int[] arr, int expected){

        int actual = longestSubArray(arr);

        System.out.printf(
                "Array=%-25s Expected=%2d Actual=%2d %s%n",
                java.util.Arrays.toString(arr),
                expected,
                actual,
                expected == actual ? "PASS" : "FAIL"
        );
    }

    // Naive Approach
    public static int longestSubArray(int[] arr){
        int res=0;

        for (int i=0;i<arr.length;i++){
            int c0=0,c1=0;
            for (int j=i;j<arr.length;j++){
                if (arr[j]==0){
                    c0++;
                }else {
                    c1++;
                }
                if (c0==c1){
                    res=Math.max(res,c0+c1);
                }
            }
        }

        return res;
    }

    //Efficient Approach using hashing
    public static int longestSubArray2(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>();

        int res = 0;
        int prefixSum = 0;

        for(int i = 0; i < arr.length; i++){

            if(arr[i] == 0){
                arr[i] = -1;
            }

            prefixSum += arr[i];

            if(prefixSum == 0){
                res = i + 1;
            }

            map.putIfAbsent(prefixSum, i);

            res = Math.max(res, i - map.get(prefixSum));
        }

        return res;
    }
}
