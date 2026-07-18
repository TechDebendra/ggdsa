package com.dsa.ds14tree;

import java.util.LinkedList;
import java.util.Queue;

public class _03SizeOfTheTree {

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Size of the tree : "+size(root));
    }

    public static int size(Node root){
        if (root == null){
            return 0;
        }else {
            return 1+size(root.left)+size(root.right);
        }
    }

    public static int sizeIterative(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int count = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            count++;

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return count;
    }
}
