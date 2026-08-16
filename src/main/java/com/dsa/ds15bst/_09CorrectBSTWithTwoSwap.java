package com.dsa.ds15bst;

public class _09CorrectBSTWithTwoSwap {
    public static Node prev = null;
    public static Node first = null;
    public static Node second = null;

    public Node correctBST(Node root){
         prev = null;
         first = null;
         second = null;
        correctBSTUtils(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        return root;
    }

    public void correctBSTUtils(Node root){
        if (root == null){
            return;
        }
        correctBSTUtils(root.left);
        if (prev != null && root.data < prev.data){
            if (first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        correctBSTUtils(root.right);

    }
}
