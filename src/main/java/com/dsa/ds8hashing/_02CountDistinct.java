package com.dsa.ds8hashing;

import java.util.HashSet;

public class _02CountDistinct {
    public static void main(String[] args) {
        Integer[] input = {2,2,4,3,6,4,8,10};
        System.out.println("Distinct element : "+countDistinct(input));


    }

    public static int countDistinct(Integer[] arr){
        HashSet<Integer> set =new HashSet<>();
        //HashSet<Integer>  set1 = new HashSet<Integer>(  Arrays.asList(arr));
        // return set1.size();
        for (int i:arr){
            set.add(i);
        }

        return set.size();
    }
}
