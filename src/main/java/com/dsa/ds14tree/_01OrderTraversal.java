package com.dsa.ds14tree;

public class _01OrderTraversal {
    public static void main(String[] args) {

        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        _01OrderTraversal tree = new _01OrderTraversal();

        System.out.print("Inorder : ");
        tree.inOrderTraversal(root);

        System.out.print("\nPreorder : ");
        tree.preOrderTraversal(root);

        System.out.print("\nPostorder : ");
        tree.postOrderTraversal(root);

        System.out.println("\nHeight of the tree : "+height(root));

        System.out.println("Elements at distance 2 :");
        printAtKDistance(root,2);
    }

    public void inOrderTraversal(Node node){
        if (node != null){
            inOrderTraversal(node.left);
            System.out.print(node.key+" ");
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node node){
        if (node != null){
            System.out.print(node.key+" ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node){
        if (node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.key+" ");
        }
    }

    // Height of the tree
    public static int height(Node root){
        if (root == null){
            return 0;
        }else {
            return Math.max(height(root.left),height(root.right))+1;
        }
    }

    // Print nodes at k distance
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
