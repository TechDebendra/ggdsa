package com.dsa.ds8hashing;

import java.util.HashMap;

public class _13CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {

        test(new int[]{10,20,20,10,30,40,10},4);

        test(new int[]{1,2,1,3,4,2,3},4);

        test(new int[]{1,2,3,4},2);

        test(new int[]{1,1,1,1},2);

        test(new int[]{1,2,3,4},4);

        test(new int[]{1},1);

        test(new int[]{},1);

        test(new int[]{1,2,1,2,1},3);

        test(new int[]{4,4,4,5,5,6},2);

        test(new int[]{1,2,3,1,2,3},3);
    }

    private static void test(int[] arr, int k){

        System.out.println("\nArray : " + java.util.Arrays.toString(arr));
        System.out.println("Window Size : " + k);

        distinctElement(arr,k);
    }

    public static void distinctElement(int[] arr, int k){

        if(arr.length == 0 || k <= 0 || k > arr.length){
            return;
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < k; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }

        System.out.println("Window 1 : " + map.size());

        int window = 2;

        for(int i = k; i < arr.length; i++){

            int outgoing = arr[i-k];

            if(map.get(outgoing) == 1){
                map.remove(outgoing);
            }else{
                map.put(outgoing, map.get(outgoing) - 1);
            }

            map.put(arr[i], map.getOrDefault(arr[i],0)+1);

            System.out.println("Window " + window + " : " + map.size());

            window++;
        }
    }
}
