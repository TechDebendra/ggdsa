package com.dsa.ds14tree;

public class _01NodeAtDistanceK {
    public static void printAtKDistance(Node root, int k){
        if (root == null){
            return;
        } else if (k == 0) {
            System.out.print(root.key+" ");
        }else {
            printAtKDistance(root.left, k-1);
            printAtKDistance(root.right,k-1);
        }
    }
}
