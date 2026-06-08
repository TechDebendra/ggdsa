package com.dsa.ds3recursive;

public class _07GenerateSubsets {
    public static void main(String[] args) {
        String str="abc";
        int index =0;
        String current ="";

        generateSubstring(str,current,index);
    }

    public static void generateSubstring(String str, String current, int index){
        if (str.length()==index){
            System.out.println(current);
            return;
        }

        generateSubstring(str,current,index+1);
        generateSubstring(str,current+str.charAt(index),index+1);
    }
}
