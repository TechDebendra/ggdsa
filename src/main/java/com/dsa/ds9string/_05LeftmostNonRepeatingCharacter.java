package com.dsa.ds9string;



public class _05LeftmostNonRepeatingCharacter {
    public static void main(String[] args) {

        System.out.println(firstNonRepeatingChar("abcd"));          // 0
        System.out.println(firstNonRepeatingChar("abca"));          // 1
        System.out.println(firstNonRepeatingChar("aabbcc"));        // -1
        System.out.println(firstNonRepeatingChar("geeksforgeeks")); // 5
        System.out.println(firstNonRepeatingChar("a"));             // 0
        System.out.println(firstNonRepeatingChar(""));              // -1
        System.out.println(firstNonRepeatingChar(null));            // -1
        System.out.println(firstNonRepeatingChar("aabbccd"));       // 6
        System.out.println(firstNonRepeatingChar("xxyz"));          // 2

    }

    //Approach - 1 :
    public static int firstNonRepeatingChar(String string){
        if (string ==null || string.isEmpty()){
            return -1;
        }
        int[] freq = new int[256];

        for (char ch : string.toCharArray()){
            freq[ch]++;
        }

        for (int i=0;i<string.length();i++){
            if (freq[string.charAt(i)] == 1){
                return i;
            }
        }

        return -1;
    }

}
