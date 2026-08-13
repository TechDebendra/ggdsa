package com.dsa.ds15bst;

public class _02InsertionInBST {

    //Recursive
    public Node insert(Node root, int key){

        if (root == null){
            return new Node(key);
        } else if (key < root.data) {
            root.left = insert(root.left,key);
        }else {
            root.right = insert(root.right,key);
        }

        return root;
    }

    //Iterative

    public Node insert1(Node root,int key){
        Node temp = new Node(key);
        if (root == null){
            return temp;
        }
        Node prev = null;
        Node curr = root;

        while (curr != null){
            prev = curr;
            if (key < curr.data){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        if (key < prev.data){
            prev.left = temp;
        }else{
            prev.right = temp;
        }
        return root;
    }
}
