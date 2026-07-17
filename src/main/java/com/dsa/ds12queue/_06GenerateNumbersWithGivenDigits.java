package com.dsa.ds12queue;

import java.util.LinkedList;
import java.util.Queue;

public class _06GenerateNumbersWithGivenDigits {
    public static void main(String[] args) {
        generateNumbers(8,5,6);
    }

    public static void generateNumbers(int count,int digit1, int digit2){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(digit1);
        queue.offer(digit2);

        while (count>=1){
            int current = queue.poll();
            System.out.println(current);
            queue.offer(current*10 + digit1);
            queue.offer(current*10 + digit2);
            count --;
        }
    }
}
