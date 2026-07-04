package com.dsa.ds9string;

import java.util.HashMap;

public class _03CheckForAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));      // true
        System.out.println(isAnagram("triangle", "integral"));  // true
        System.out.println(isAnagram("abcd", "dcba"));          // true
        System.out.println(isAnagram("aabb", "bbaa"));          // true
        System.out.println(isAnagram("abc", "abd"));            // false
        System.out.println(isAnagram("abc", "ab"));             // false
        System.out.println(isAnagram("", ""));                  // true
        System.out.println(isAnagram("a", "a"));                // true
        System.out.println(isAnagram("a", "b"));                // false
        System.out.println(isAnagram(null, "abc"));             // false

    }

    public static boolean isAnagram(String str1, String str2){
        if (str1 ==null || str2 ==null){
            return false;
        }
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 != len2){
            return false;
        }

        HashMap<Character,Integer> charFreqMap = new HashMap<>();

        for (int i=0 ; i<len1;i++){
            charFreqMap.put(str1.charAt(i),charFreqMap.getOrDefault(str1.charAt(i),0)+1);
        }

        for (char ch : str2.toCharArray()){
            int freq = charFreqMap.getOrDefault(ch,0);

            if (freq == 0){
                return false;
            }

            charFreqMap.put(ch,freq-1);

        }

        return true;
    }

    public static boolean isAnagram_1(String str1, String str2) {

        if (str1 == null || str2 == null)
            return false;

        if (str1.length() != str2.length())
            return false;

        int[] freq = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i)]++;
            freq[str2.charAt(i)]--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }
}
