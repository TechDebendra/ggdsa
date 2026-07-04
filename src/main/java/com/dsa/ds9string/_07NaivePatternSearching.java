package com.dsa.ds9string;

public class _07NaivePatternSearching {
    public static void main(String[] args) {
        String input = "AAAAA";
        String pattern = "AA";
        search(input,pattern);
    }
    //Naive Approach
    public static void search(String str, String pattern){
        if (str == null || pattern == null || str.isEmpty() || pattern.isEmpty()){
            throw new IllegalArgumentException("Invalid Input!");
        }

        int n1 = str.length();
        int n2 = pattern.length();

        if (n2 > n1){
            System.out.println("Not found!");
            return;
        }
        boolean found = false;
        for (int i=0;i<=n1-n2;i++){
            int j;
            for (j=0;j<n2;j++){
                if (str.charAt(i+j)!=pattern.charAt(j)){
                    break;
                }
            }
            if (j==n2){
                System.out.println(i);
                found = true;
            }
        }

        if (!found){
            System.out.println("Not found!");
        }

    }

    // Optimised Naive Approach while pattern having distinct characters
    public static void search2(String str, String pattern){
        if (str == null || pattern == null || str.isEmpty() || pattern.isEmpty()){
            throw new IllegalArgumentException("Invalid Input!");
        }

        int n1 = str.length();
        int n2 = pattern.length();

        if (n2 > n1){
            System.out.println("Not found!");
            return;
        }
        boolean found = false;
        for (int i=0;i<=n1-n2; ){
            int j;
            for (j=0;j<n2;j++){
                if (str.charAt(i+j)!=pattern.charAt(j)){
                    break;
                }
            }
            if (j==n2){
                System.out.println(i);
                found = true;
            }
            if (j==0){
                i++;
            }else {
                i=i+j;
            }
        }

        if (!found){
            System.out.println("Not found!");
        }

    }

}
