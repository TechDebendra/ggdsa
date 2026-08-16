package com.dsa.ds15bst;

public class _07KthSmallestElement {
    public static int count = 0;


    public static Node findKthSmallestElement(Node root,int k){
        count=0;
        return kthSmallest(root,k);
    }

    public static Node kthSmallest(Node root, int k){

        if (root == null){
            return null;
        }
        Node left = kthSmallest(root.left,k);

        //If kth element found in left side return it.
        if (left != null){
            return left;
        }
        count++;

        // If current element is kth smallest element.
        if (count == k){
            return root;
        }

        return kthSmallest(root.right,k);
    }
}
