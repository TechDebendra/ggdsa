package com.dsa.ds9string;

public class _08RobinKarpAlgorithm {

    public static final int d = 256;
    public static void main(String[] args) {
        robinKarpSearch("GEEKS FOR GEEKS", "GEEK");
        System.out.println();

        robinKarpSearch("AAAAA", "AAA");
        System.out.println();

        robinKarpSearch("ABCDE", "BCD");
        System.out.println();

        robinKarpSearch("ABCDE", "XYZ");

    }

    public static void robinKarpSearch(String txt, String ptr){
        if (txt == null || ptr == null || txt.isEmpty() || ptr.isEmpty()){
            throw new IllegalArgumentException("Invalid Input!");
        }


        int n = txt.length();
        int m = ptr.length();

        if (m > n) {
            System.out.println("Pattern not found");
            return;
        }

        int q = 101;
        int h = 1;

        //calculate h= (d^m-1)%q
        for (int i=1; i<=m-1;i++){
            h=(h*d)%q;
        }

        int p = 0; // hash of pattern
        int t = 0; // hash of current window

        for (int i=0;i<m;i++){
            p = (d*p + ptr.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }
        boolean isFound = false;
        for (int i=0; i<=n-m;i++){
            if (p == t){
                int j;
                boolean flag= true;
                for (j=0;j<m;j++){
                    if (txt.charAt(i+j)!=ptr.charAt(j)){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    System.out.println(i);
                    isFound = true;
                }
            }

            if (i<n-m){
                t = (d*(t-txt.charAt(i)*h) + txt.charAt(i+m))%q;
                if (t<0){
                    t=t+q;
                }
            }
        }

        if (!isFound){
            System.out.println("Not Found!");
        }
    }

}
