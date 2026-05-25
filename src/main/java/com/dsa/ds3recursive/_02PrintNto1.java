package com.dsa.ds3recursive;

public class _02PrintNto1 {
    public static void main(String[] args) {
        display(10);

    }

    public static void display(int n){
        if (n==0) return;
        System.out.println(n);
        display(n-1);
    }
}
