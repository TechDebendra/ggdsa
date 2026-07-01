package com.dsa.ds8hashing;

import java.util.HashSet;

public class _06PairWithGivenSumInUnsortedArray {

    public static void main(String[] args) {

        test(new int[]{8,4,7,9},13,true);

        test(new int[]{3,2,8,15,-8},17,true);

        test(new int[]{1,2,3,4},10,false);

        test(new int[]{5,5},10,true);

        test(new int[]{5},10,false);

        test(new int[]{},10,false);

        test(new int[]{-5,-2,-8,-1},-3,true);

        test(new int[]{-5,-2,-8,-1},-20,false);

        test(new int[]{2,2,2,2},4,true);

        test(new int[]{0,4,3,0},0,true);

        test(new int[]{10,20,30,40},50,true);

        test(new int[]{10,20,30,40},100,false);
    }

    public static boolean isPair(int[] arr, int sum){

        HashSet<Integer> set = new HashSet<>();

        for(int k : arr){

            if(set.contains(sum-k)){
                return true;
            }

            set.add(k);
        }

        return false;
    }

    private static void test(int[] arr,int sum,boolean expected){

        boolean actual = isPair(arr,sum);

        System.out.printf(
                "Array=%-25s Sum=%3d Expected=%-5b Actual=%-5b %s%n",
                java.util.Arrays.toString(arr),
                sum,
                expected,
                actual,
                expected==actual ? "PASS" : "FAIL"
        );
    }
}