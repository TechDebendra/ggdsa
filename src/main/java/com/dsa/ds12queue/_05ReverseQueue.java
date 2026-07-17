package com.dsa.ds12queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _05ReverseQueue {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Original Queue : " + queue);

        reverse(queue);

        System.out.println("Reversed Queue : " + queue);
    }

    public static Queue<Integer> reverse(Queue<Integer> queue){
        if (queue == null) {
            throw new IllegalArgumentException("Queue cannot be null");
        }
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }

        return queue;
    }

    public static void recursiveReverse(Queue<Integer> queue){
        if (queue.isEmpty()){
            return;
        }
        int x = queue.poll();
        recursiveReverse(queue);
        queue.add(x);
    }
}
