package com.dsa.ds14tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _19IterativePreorderTraversal {

    public static void iterativePreorderTraversal(Node root){
        if (root == null){
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node current = stack.pop();
            System.out.print(current.key+" ");
            if (current.right != null){
                stack.push(current.right);
            }
            if (current.left != null){
                stack.push(current.left);
            }
        }
    }

    public static void iterativePreorderTraversalOptimised(Node root){
        if (root == null){
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        while (current != null || !stack.isEmpty()){

            while (current != null){
                System.out.print(current.key+" ");
                if (current.right != null){
                    stack.push(current.right);
                }
                current = current.left;
            }

            if (!stack.isEmpty()){
                current = stack.pop();
            }
        }

    }
}
