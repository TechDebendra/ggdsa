package com.dsa.ds6sorting;

import java.util.Arrays;
import java.util.Comparator;

public class _20MergeOverlappingIntervals {

    public static void main(String[] args) {

        test("Test 1 : Your Example",
                new Interval[]{
                        new Interval(1, 4),
                        new Interval(1, 6),
                        new Interval(2, 8),
                        new Interval(10, 13),
                        new Interval(3, 9),
                        new Interval(23, 45)
                });

        test("Test 2 : No Overlap",
                new Interval[]{
                        new Interval(1, 2),
                        new Interval(4, 5),
                        new Interval(7, 9)
                });

        test("Test 3 : Complete Overlap",
                new Interval[]{
                        new Interval(1, 10),
                        new Interval(2, 3),
                        new Interval(4, 5),
                        new Interval(6, 7)
                });

        test("Test 4 : Chain Overlap",
                new Interval[]{
                        new Interval(1, 3),
                        new Interval(2, 4),
                        new Interval(4, 6),
                        new Interval(6, 8)
                });

        test("Test 5 : Touching Intervals",
                new Interval[]{
                        new Interval(1, 2),
                        new Interval(2, 3),
                        new Interval(3, 4)
                });

        test("Test 6 : Same Start",
                new Interval[]{
                        new Interval(1, 5),
                        new Interval(1, 3),
                        new Interval(1, 7)
                });

        test("Test 7 : Same End",
                new Interval[]{
                        new Interval(1, 5),
                        new Interval(2, 5),
                        new Interval(4, 5)
                });

        test("Test 8 : Single Interval",
                new Interval[]{
                        new Interval(5, 8)
                });

        test("Test 9 : Empty Array",
                new Interval[]{});

        test("Test 10 : Negative Values",
                new Interval[]{
                        new Interval(-10, -5),
                        new Interval(-8, -2),
                        new Interval(0, 3)
                });

        test("Test 11 : Unsorted Input",
                new Interval[]{
                        new Interval(10, 20),
                        new Interval(2, 5),
                        new Interval(4, 12),
                        new Interval(30, 40)
                });

        test("Test 12 : Nested Intervals",
                new Interval[]{
                        new Interval(1, 100),
                        new Interval(20, 30),
                        new Interval(40, 50),
                        new Interval(60, 70)
                });

        test("Test 13 : Duplicate Intervals",
                new Interval[]{
                        new Interval(1, 4),
                        new Interval(1, 4),
                        new Interval(1, 4)
                });

        test("Test 14 : Large Gap",
                new Interval[]{
                        new Interval(1, 2),
                        new Interval(100, 200),
                        new Interval(300, 400)
                });

        test("Test 15 : Mixed Case",
                new Interval[]{
                        new Interval(6, 8),
                        new Interval(1, 9),
                        new Interval(2, 4),
                        new Interval(4, 7)
                });
    }

    private static void test(String title, Interval[] input) {
        System.out.println("\n==========================================");
        System.out.println(title);
        System.out.println("==========================================");

        System.out.println("Input:");
        printIntervals(input);

        mergeIntervals(input);
    }

    public static void mergeIntervals(Interval[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("Output:");
            System.out.println("No intervals");
            return;
        }

        Arrays.sort(arr, new MyComparator());

        System.out.println("\nAfter Sorting:");
        printIntervals(arr);

        int res = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i].start <= arr[res].end) {

                // Since array is sorted, start remains same.
                arr[res].end = Math.max(arr[res].end, arr[i].end);

            } else {

                res++;
                arr[res] = arr[i];

            }
        }

        System.out.println("\nMerged Output:");

        for (int i = 0; i <= res; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void printIntervals(Interval[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("No intervals");
            return;
        }

        for (Interval interval : arr) {
            System.out.println(interval);
        }
    }

    static class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.start, i2.start);
        }
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}