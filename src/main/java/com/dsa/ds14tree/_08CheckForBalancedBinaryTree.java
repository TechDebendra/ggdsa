package com.dsa.ds14tree;

public class _08CheckForBalancedBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        if (isBalanced(root) != -1){
            System.out.println("Balanced tree!");
        }else {
            System.out.println("Not a balanced tree!");
        }

    }

    public static int isBalanced(Node root){
        if (root == null){
            return 0;
        }

        int lh = isBalanced(root.left);
        if (lh == -1){
            return -1;
        }

        int rh = isBalanced(root.right);
        if (rh == -1){
            return -1;
        }

        return Math.abs(lh - rh) > 1 ? -1 : Math.max(lh,rh)+1;
    }
}
