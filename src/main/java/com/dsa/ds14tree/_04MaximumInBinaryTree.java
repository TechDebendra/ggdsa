package com.dsa.ds14tree;

import java.util.LinkedList;
import java.util.Queue;

public class _04MaximumInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Max of the tree : "+max(root));
        System.out.println("Max of the tree : "+iterativeMax(root));
    }

    public static int max(Node root){
        if (root == null){
            return Integer.MIN_VALUE;
        }else {
            return Math.max(
                    root.key,
                    Math.max(max(root.left),max(root.right))
            );
        }
    }

    public static int iterativeMax(Node root){
        if (root == null){
            return Integer.MIN_VALUE;
        }

        Queue<Node> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        queue.add(root);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            max = Math.max(current.key, max);
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
        return max;
    }
}
