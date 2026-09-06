package com.dsa.ds18greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _01MinNoOfCoin {

    public static void main(String[] args) {
        int[] input = {10,2,1,5};
        int res = minNoOfCoins(input,52);
        System.out.println("Amount 52, result : "+res);

        int res1 = minNoOfCoins(input,57);
        System.out.println("Amount 57, result : "+res1);
    }
    public static int minNoOfCoins(int[] coins, int amount){
        List<Integer> list = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).toList();

        int count = 0;
        for (int i : list){
            int rem = amount / i;
            count += rem;
            amount = amount - (i * rem);
            if (amount == 0 ){
                break;
            }
        }

        return count;
    }
}
