package com.dsa.ds15bst;

public class _05CeilingInBST {

    public Node ceil(Node root, int key){
        Node ceil = null;

        while (root != null){
            if (key < root.data){
                ceil = root;
                root = root.left;
            }else if (key > root.data){
                root = root.right;
            }else {
                return root;
            }
        }
        return ceil;
    }
}
