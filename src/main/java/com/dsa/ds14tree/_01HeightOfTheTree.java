package com.dsa.ds14tree;

public class _01HeightOfTheTree {

    public static int height(Node root){
        if (root == null){
            return 0;
        }else {
            return Math.max(height(root.left),height(root.right))+1;
        }
    }
}
