package com.dsa.ds9string;

import java.util.Arrays;
import java.util.HashMap;

public class _11LongestUniqueSubString {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);
        int len = longestUniqueSubString(str);
        System.out.println("The length of the longest "
                + "non-repeating character "
                + "substring is " + len);

    }
   // Approach - 1 :
    public static int longestUniqueSubString(String string){
        if (string == null){
            throw new IllegalArgumentException("Invalid Input!");
        }

        if (string.isEmpty()){
            return 0;
        }

        if (string.length() == 1){
            return 1;
        }
        int maxLength=1;
        String test="";

        for (char c : string.toCharArray()) {
            String current = String.valueOf(c);

            // If string already contains the character
            // Then substring after repeating character
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current)
                        + 1);
            }
            test = test + c;
            maxLength = Math.max(test.length(), maxLength);
        }
        return maxLength;
    }
    // Approach - 2 :

    public static int longestSubString2(String string){
        if (string == null){
            throw new IllegalArgumentException("Invalid Input!");
        }

        if (string.isEmpty()){
            return 0;
        }
        int[] prevIndex=new int[256];

        Arrays.fill(prevIndex,-1);;
        int maxLen=0;
        int res=0;
        int start=0;
        for (int end=0;end<string.length();end++){
             start = Math.max(start, prevIndex[string.charAt(end)] + 1);
             maxLen = end - start +1;
             res = Math.max(res , maxLen);
             prevIndex[string.charAt(end)] = end;
        }
        return res;
    }

    // Approach - 3 :
    public static int longestSubString3(String string){
        if (string == null){
            throw new IllegalArgumentException("Invalid Input!");
        }

        if (string.isEmpty()){
            return 0;
        }
        HashMap<Character,Integer> seen = new HashMap<>();
        int res=0;
        int start=0;

        for (int end=0;end<string.length();end++){
            char ch = string.charAt(end);
            if (seen.containsKey(ch)){
                start = Math.max(start,seen.get(ch)+1);
            }
            seen.put(ch,end);
            res = Math.max(res,end-start+1);

        }

        return res;
    }
}
