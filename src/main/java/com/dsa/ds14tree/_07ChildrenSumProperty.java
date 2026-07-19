package com.dsa.ds14tree;

public class _07ChildrenSumProperty {

    public static void main(String[] args) {
        Node root = new Node(60);

        root.left = new Node(20);
        root.right = new Node(40);

        root.left.left = new Node(12);
        root.left.right = new Node(8);

        root.right.left = new Node(10);
        root.right.right = new Node(30);

        System.out.println("Is children sum : "+isChildrenSum(root));

    }

    public static boolean isChildrenSum(Node root){
        if (root == null){
            return true;
        }

        if (root.left == null && root.right == null){
            return true;
        }
        int sum = 0;
        if (root.left != null){
            sum += root.left.key;
        }
        if (root.right != null){
            sum += root.right.key;
        }

        return root.key == sum && isChildrenSum(root.left) && isChildrenSum(root.right);
    }
}
