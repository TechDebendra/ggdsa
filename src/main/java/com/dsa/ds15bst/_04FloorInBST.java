package com.dsa.ds15bst;

public class _04FloorInBST {

    public Node floor(Node root, int key) {
        Node floor = null;

        while (root != null) {
            if (key < root.data) {
                root = root.left;
            } else if (key > root.data) {
                floor = root;
                root = root.right;
            } else {
                return root; // exact match
            }
        }

        return floor;
    }
}
