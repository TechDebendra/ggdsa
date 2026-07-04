package com.dsa.ds9string;

import java.util.Arrays;

public class _04LeftmostRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(findFirstRepeatingChar("abcd"));          // -1
        System.out.println(findFirstRepeatingChar("abca"));          // 0
        System.out.println(findFirstRepeatingChar("geeksforgeeks")); // 0
        System.out.println(findFirstRepeatingChar("abcda"));         // 0
        System.out.println(findFirstRepeatingChar("abccbd"));        // 1
        System.out.println(findFirstRepeatingChar(""));              // -1
        System.out.println(findFirstRepeatingChar(null));            // -1
        System.out.println(findFirstRepeatingChar("aaaa"));          // 0
        System.out.println(findFirstRepeatingChar("abcdec"));        // 2

    }

    public static int findFirstRepeatingChar(String string){
        if (string ==null || string.isEmpty()){
            return -1;
        }

        int[] freq = new int[256];

        Arrays.fill(freq,-1);
        int res = Integer.MAX_VALUE;  // used to gold the left most repeating char index
        for (int i=0;i<string.length();i++){
            char ch = string.charAt(i);
            int fi=freq[ch];

            if (fi == -1){
                freq[ch]=i;
            }else {
                res=Math.min(res,fi);
            }

        }

        return res==Integer.MAX_VALUE ? -1 : res;
    }

    public static int findFirstRepeatingChar_1(String string){
        if (string == null || string.isEmpty()){
            return -1;
        }

        int res=Integer.MAX_VALUE;

        boolean[] visited = new boolean[256];

        for (int i=string.length()-1;i>=0;i--){
            if (visited[string.charAt(i)]){
                res=i;
            }else {
                visited[string.charAt(i)]=true;
            }
        }

        return res==Integer.MAX_VALUE ? -1 : res;

    }

    public static int findFirstRepeatingChar_2(String string){
       if (string == null || string.isEmpty()){
           return -1;
       }

       int[] freq = new int[256];

       for (char ch : string.toCharArray()){
           freq[ch]++;
       }

      for (int i=0;i<string.length();i++){

          if (freq[string.charAt(i)] > 1){
              return i;
          }
      }

       return -1;
    }
}
