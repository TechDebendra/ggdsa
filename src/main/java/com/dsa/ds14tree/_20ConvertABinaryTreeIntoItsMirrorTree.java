package com.dsa.ds14tree;

public class _20ConvertABinaryTreeIntoItsMirrorTree {

    public static void convertIntoMirror(Node root){
        if (root == null){
            return;
        }

        convertIntoMirror(root.left);
        convertIntoMirror(root.right);

        Node temp;
        temp = root.right;
        root.right = root.left;
        root.left = temp;

    }
}
