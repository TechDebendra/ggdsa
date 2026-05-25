package com.dsa.ds3recursive;

public class _03Print1toN {
    public static void main(String[] args) {
        display(10);
    }
    public static void display(int n){
        if (n==0) return;
        display(n-1);
        System.out.println(n);
    }
}
