package com.dsa.ds15bst;

public class _08CheckForBST {

    public static int prev = Integer.MIN_VALUE;

    public static boolean isBSTTree(Node root){
        prev = Integer.MIN_VALUE;
        return isBST(root);
    }

    public static boolean isBST(Node root){
        if (root == null){
            return true;
        }
        if (!isBST(root.left)){
            return false;
        }
        if (root.data <= prev){
            return false;
        }
        prev = root.data;
        return isBST(root.right);
    }

    public static boolean isBST2(Node root,int min,int max){
        if (root == null){
            return true;
        }
        return root.data > min &&
                root.data < max  &&
                isBST2(root.left,min,root.data) &&
                isBST2(root.right,root.data,max);

    }
}
