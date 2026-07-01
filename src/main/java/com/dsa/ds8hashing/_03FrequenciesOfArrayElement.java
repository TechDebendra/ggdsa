package com.dsa.ds8hashing;

import java.util.HashMap;
import java.util.Map;

public class _03FrequenciesOfArrayElement {
    public static void main(String[] args) {
        int[] input= {2,3,4,5,3,4,5,2,4,5,6,77,23,10};
        frequencies(input);

    }

    public static void frequencies(int[] arr){
        HashMap<Integer,Integer> frequenciesMap = new HashMap<>();

        for (int i : arr){
            frequenciesMap.put(i,frequenciesMap.getOrDefault(i,0)+1);
        }

        for (Map.Entry<Integer,Integer> entry : frequenciesMap.entrySet()){
            System.out.println("Element : "+entry.getKey()+" Frequencies :"+entry.getValue());
        }
    }
}
