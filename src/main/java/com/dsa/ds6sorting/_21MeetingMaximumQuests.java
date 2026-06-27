package com.dsa.ds6sorting;

import java.util.Arrays;

public class _21MeetingMaximumQuests {

    public static void main(String[] args) {

        test("Test 1 : GFG Example",
                new int[]{900, 600, 700},
                new int[]{1000, 800, 730});

        test("Test 2 : Mixed Times",
                new int[]{1, 2, 10, 5, 5},
                new int[]{4, 5, 12, 9, 12});

        test("Test 3 : All Guests Overlap",
                new int[]{1, 2, 3},
                new int[]{10, 10, 10});

        test("Test 4 : No Overlap",
                new int[]{1, 5, 10},
                new int[]{2, 6, 11});

        test("Test 5 : Same Arrival Time",
                new int[]{1, 1, 1},
                new int[]{2, 2, 2});

        test("Test 6 : Same Departure Time",
                new int[]{1, 2, 3},
                new int[]{5, 5, 5});

        test("Test 7 : Arrival Equals Departure",
                new int[]{1, 3, 5},
                new int[]{3, 5, 6});

        test("Test 8 : Duplicate Arrivals",
                new int[]{2, 2, 2, 2},
                new int[]{5, 5, 5, 5});

        test("Test 9 : Reverse Order Input",
                new int[]{8, 2, 6, 1},
                new int[]{9, 5, 7, 4});

        test("Test 10 : Single Guest",
                new int[]{5},
                new int[]{10});

        test("Test 11 : Large Dataset",
                new int[]{1, 4, 6, 8, 10, 12, 14},
                new int[]{5, 7, 9, 15, 16, 18, 20});

        test("Test 12 : Continuous Overlap",
                new int[]{1, 2, 3, 4, 5},
                new int[]{10, 10, 10, 10, 10});

        test("Test 13 : Alternate Arrival & Departure",
                new int[]{1, 3, 5, 7},
                new int[]{2, 4, 6, 8});

        test("Test 14 : Random Input",
                new int[]{15, 3, 12, 20, 7},
                new int[]{25, 10, 15, 30, 18});

        test("Test 15 : Empty Arrays",
                new int[]{},
                new int[]{});
    }

    private static void test(String title, int[] arr, int[] dep) {

        System.out.println("\n========================================");
        System.out.println(title);
        System.out.println("========================================");

        System.out.println("Arrival   : " + Arrays.toString(arr));
        System.out.println("Departure : " + Arrays.toString(dep));

        try {
            maxGuests(arr, dep);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void maxGuests(int[] arr, int[] dep) {

        if (arr == null || dep == null ||
                arr.length != dep.length ||
                arr.length == 0) {

            throw new IllegalArgumentException("Invalid Input!");
        }

        // Clone arrays to preserve original input
        arr = arr.clone();
        dep = dep.clone();

        Arrays.sort(arr);
        Arrays.sort(dep);

        System.out.println("\nAfter Sorting");
        System.out.println("Arrival   : " + Arrays.toString(arr));
        System.out.println("Departure : " + Arrays.toString(dep));

        int n = arr.length;

        int i = 1;
        int j = 0;

        int guests = 1;
        int maxGuests = 1;
        int arrivalTime = arr[0];

        while (i < n && j < n) {

            // New guest arrives
            if (arr[i] <= dep[j]) {

                guests++;

                if (guests > maxGuests) {
                    maxGuests = guests;
                    arrivalTime = arr[i];
                }

                i++;

            } else {

                // Guest leaves
                guests--;
                j++;
            }
        }

        System.out.println("\nOutput");
        System.out.println("Maximum Guests : " + maxGuests);
        System.out.println("Time           : " + arrivalTime);
    }
}