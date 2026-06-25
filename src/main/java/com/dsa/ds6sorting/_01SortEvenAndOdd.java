package com.dsa.ds6sorting;

import java.util.Arrays;
import java.util.Comparator;

//Sort an array in such a way that all even number comes first and then odd numbers.
public class _01SortEvenAndOdd {

    public static void main(String[] args) {
        Integer[] arr = {1,7,6,5,8,0};

        Arrays.sort(arr,new MyComparator());

        System.out.println(Arrays.toString(arr));


    }

    static class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer n, Integer m) {
            return n%2-m%2;
        }
    }
}
