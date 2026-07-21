package com.dsa.ds14tree;

public class _13DiameterOfBinaryTree {

    public int result = 0;
    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        _13DiameterOfBinaryTree tree = new _13DiameterOfBinaryTree();
        tree.diameter(root);
        System.out.println("Diameter : "+tree.result);
    }

    public int diameter(Node root){
        if (root == null){
            return 0;
        }
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        result = Math.max(result, lh + rh + 1);

        return Math.max(lh,rh)+1;
    }
}
