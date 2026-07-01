package com.dsa.ds8hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class _12LongestConsecutiveSubsequence {
    public static void main(String[] args) {

        test(new int[]{1,9,3,10,4,20,2},4);

        test(new int[]{8,20,7,30},2);

        test(new int[]{1,2,3,4,5},5);

        test(new int[]{5,4,3,2,1},5);

        test(new int[]{100},1);

        test(new int[]{},0);

        test(new int[]{1,1,1,1},1);

        test(new int[]{1,2,2,3,4},4);

        test(new int[]{10,5,12,3,55,30,4,11,2},4);

        test(new int[]{7,6,5,4,3,2,1},7);

        test(new int[]{50,3,10,7,40,80},1);

        test(new int[]{-2,-1,0,1,2},5);

        test(new int[]{-5,-4,-3,7,8,9,10},4);

        test(new int[]{2,2,3,4,4,5},4);
    }

    private static void test(int[] arr,int expected){

        int actual1 = longestSubsequence(arr.clone());
        int actual2 = longestSub(arr.clone());

        System.out.printf(
                "Array=%-35s Expected=%2d Sort=%2d Hash=%2d %s%n",
                Arrays.toString(arr),
                expected,
                actual1,
                actual2,
                (actual1==expected && actual2==expected)
                        ? "PASS"
                        : "FAIL"
        );
    }
    public static int longestSubsequence(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int res=1;

        Arrays.sort(arr);

        int current=1;

        for (int i=1;i<arr.length;i++){
            if (arr[i]==arr[i-1]+1){
                current++;
            }else if (arr[i]!=arr[i-1]){
                res=Math.max(res,current);
                current=1;
            }
        }

        return Math.max(res,current);
    }

    public static int longestSub(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int res=1;
        HashSet<Integer> set = new HashSet<>();

        for (int i : arr){
            set.add(i);
        }

        for (int i: set){
            if (!set.contains(i-1)){
                int curr=1;
                while (set.contains(i+curr)){
                    curr++;
                }
                res=Math.max(res,curr);
            }
        }

        return res;
    }

    public static int findLongestConseqSubseq(int[] arr){

        if(arr.length == 0){
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num : arr){
            queue.offer(num);
        }

        int prev = queue.poll();

        int count = 1;
        int res = 1;

        while(!queue.isEmpty()){

            int curr = queue.poll();

            if(curr == prev){
                continue;
            }

            if(curr == prev + 1){
                count++;
            }else{
                count = 1;
            }

            prev = curr;
            res = Math.max(res, count);
        }

        return res;
    }
}
