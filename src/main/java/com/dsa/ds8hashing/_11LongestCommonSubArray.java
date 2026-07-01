package com.dsa.ds8hashing;

import java.util.HashMap;

public class _11LongestCommonSubArray {
    public static void main(String[] args) {

        test(new int[]{0,1,0,0,0,0},
                new int[]{1,0,1,0,0,1},
                4);

        test(new int[]{1,0,0,1,0,1},
                new int[]{0,1,0,1,0,1},
                6);

        test(new int[]{0,0,0,0},
                new int[]{0,0,0,0},
                4);


        test(new int[]{1,1,0,1,0},
                new int[]{0,1,1,0,1},
                4);


    }

    private static void test(int[] arr1, int[] arr2, int expected){

        int actual1 = longestSubarray(arr1, arr2);
        int actual2 = longestSubarray2(arr1, arr2);

        System.out.printf(
                "A=%-20s B=%-20s Expected=%2d Naive=%2d Efficient=%2d %s%n",
                java.util.Arrays.toString(arr1),
                java.util.Arrays.toString(arr2),
                expected,
                actual1,
                actual2,
                (actual1 == expected && actual2 == expected) ? "PASS" : "FAIL"
        );
    }

    public static int longestSubarray(int[] arr1, int[] arr2){
        int res=0;

        for (int i=0; i<arr1.length;i++){
            int sum1=0,sum2=0;

            for (int j=i;j< arr1.length;j++){
                sum1+=arr1[j];
                sum2+=arr2[j];

                if (sum1==sum2){
                    res=Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }


    //Efficient Approach
    public static int longestSubarray2(int[] arr1, int[] arr2){

        int[] temp = new int[arr1.length];

        for(int i = 0; i < arr1.length; i++){
            temp[i] = arr1[i] - arr2[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        int prefixSum = 0;
        int res = 0;

        for(int i = 0; i < temp.length; i++){

            prefixSum += temp[i];

            if(prefixSum == 0){
                res = i + 1;
            }

            if(map.containsKey(prefixSum)){
                res = Math.max(res,
                        i - map.get(prefixSum));
            }else{
                map.put(prefixSum, i);
            }
        }

        return res;
    }
}
