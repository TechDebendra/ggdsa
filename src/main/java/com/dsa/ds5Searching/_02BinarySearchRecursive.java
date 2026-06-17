package com.dsa.ds5Searching;

public class _02BinarySearchRecursive {
    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30, 40, 50, 60};

        // Test Case 1: Element present in middle
        System.out.println(binarySearch(arr1,0,arr1.length-1, 30)); // 2

        // Test Case 2: First element
        System.out.println(binarySearch(arr1, 0,arr1.length-1,10)); // 0

        // Test Case 3: Last element
        System.out.println(binarySearch(arr1,0,arr1.length-1, 60)); // 5

        // Test Case 4: Element not present
        System.out.println(binarySearch(arr1,0,arr1.length-1, 35)); // -1

        // Test Case 5: Single element array (found)
        int[] arr2 = {100};
        System.out.println(binarySearch(arr2, 0,arr2.length-1,100)); // 0

        // Test Case 6: Single element array (not found)
        System.out.println(binarySearch(arr2,0,arr2.length-1, 50)); // -1

        // Test Case 7: Empty array
        int[] arr3 = {};
        System.out.println(binarySearch(arr3, 0,arr3.length-1,10)); // -1

        // Test Case 8: Negative numbers
        int[] arr4 = {-20, -10, 0, 10, 20};
        System.out.println(binarySearch(arr4,0,arr4.length-1, -10)); // 1
    }

    /**
     * Performs Binary Search using recursion.
     *
     * @param arr   Sorted input array
     * @param start Starting index
     * @param end   Ending index
     * @param x     Element to search
     * @return Index of x if found, otherwise -1
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to recursion stack
     */

    public static int binarySearch(int[] arr, int start,int end, int x){
        if (start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if (x==arr[mid]){
            return mid;
        }else if (x<arr[mid]){
           return binarySearch(arr,start,mid-1,x);
        }else {
            return binarySearch(arr,mid+1,end,x);
        }
    }
}
