package com.dsa.ds14tree;

public class _10BinaryTreeToDoubleLinkedList {

    public static Node prev;
    public static Node head;


    public static Node convert(Node root){
        if (root == null){
            return null;
        }
        convert(root.left);

        if (prev == null){
            head = root;
        }else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        convert(root.right);

        return head;
    }
}
