package com.dsa.ds9string;

public class _06ReverseWordsInAString {
    public static void main(String[] args) {
        String input = "I love my india";
        System.out.println(input);
        String result = reverseWords(input);
        System.out.println(result);

    }

    public static String reverseWordsInString(String string){

        char[] chars = string.toCharArray();
        int n = chars.length;
        int start=0;
        for (int i=0;i<n;i++){

            if (chars[i]==' '){
                reverse(chars,start,i-1);
                start=i+1;
            }
        }

        reverse(chars,start,n-1); // To reverse last word
        reverse(chars,0,n-1); // To reverse final string

        return new String(chars);

    }


    public static char[] reverse(char[] chars,int start,int end){

        while (start<=end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return chars;
    }

    public static String reverseWords(String string){
        if (string == null || string.isEmpty()){
            return string;
        }
        String[] strArray = string.split(" ");

        int start = 0 ;
        int end = strArray.length-1;

        while (start <= end){
            String temp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = temp;
            start++;
            end--;
        }

         return String.join(" ",strArray);
    }
}
