package com.dsa.ds14tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _18IterativeInorderTraversal {

    public static void iterativeInorderTraversal(Node root){
        if (root == null){
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();

        Node current = root;

        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.key+" ");
            current = current.right;
        }
    }
}
