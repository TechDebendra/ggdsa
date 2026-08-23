package com.dsa.ds16heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _08MergeKSortedArray {
    static class Triplet implements Comparable<Triplet> {
        int value;
        int arrayPosition;
        int arrayIndex;

        public Triplet(int value, int arrayPosition, int arrayIndex) {
            this.value = value;
            this.arrayPosition = arrayPosition;
            this.arrayIndex = arrayIndex;
        }

        public int compareTo(Triplet triplet) {
            return this.value - triplet.value;
        }

    }

    public static ArrayList<Integer> mergeKSortedArray(int[][] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        PriorityQueue<Triplet> queue = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].length > 0) {
                queue.add(new Triplet(arr[i][0], i, 0));
            }
        }

        while (!queue.isEmpty()) {

            Triplet curr = queue.poll();
            result.add(curr.value);

            if (curr.arrayIndex + 1 < arr[curr.arrayPosition].length) {
                queue.add(
                        new Triplet(
                                arr[curr.arrayPosition][curr.arrayIndex + 1],
                                curr.arrayPosition,
                                curr.arrayIndex + 1
                        )
                );
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30},
                {5, 15},
                {1, 9, 11, 18}
        };

        ArrayList<Integer> result = mergeKSortedArray(arr);

        System.out.println(result);
    }
}