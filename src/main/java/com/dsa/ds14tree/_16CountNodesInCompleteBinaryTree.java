package com.dsa.ds14tree;

public class _16CountNodesInCompleteBinaryTree {

    //Naive Approach
    public static int countNodes(Node root){
        if (root == null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    //Efficient Approach
    public static int countNodesOptimised(Node root){
        if (root == null){
            return 0;
        }
        Node current = root;
        int lh = 0, rh = 0;

        while (current != null){
            lh++;
            current = current.left;
        }

        current = root;

        while (current != null){
            rh++;
            current = current.right;
        }

        if (lh == rh){
            return (int) (Math.pow(2,lh)-1);
        }

        return countNodesOptimised(root.left)+countNodesOptimised(root.right)+1;
    }
}
