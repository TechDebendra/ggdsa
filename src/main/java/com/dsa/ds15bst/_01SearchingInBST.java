package com.dsa.ds15bst;

public class _01SearchingInBST {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        _01SearchingInBST bst = new _01SearchingInBST();

        // Case 1: Key exists
        System.out.println(bst.search(root, 60));   // true

        // Case 2: Key does not exist
        System.out.println(bst.search(root, 90));   // false
    }

    // Recursive
    public boolean search(Node root, int key){
        if (root == null){
            return false;
        } else if (root.data == key) {
            return true;
        } else if (key < root.data) {
            return search(root.left,key);
        }else {
            return search(root.right,key);
        }
    }

    // Iterative
    public boolean search1(Node root,int key){
         while (root != null){
             if (root.data == key){
                 return true;
             }else if (key < root.data){
                 root = root.left;
             }else {
                 root = root.right;
             }

         }

         return false;
    }
}
