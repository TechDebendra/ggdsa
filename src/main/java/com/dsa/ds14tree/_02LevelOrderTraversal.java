package com.dsa.ds14tree;

import java.util.LinkedList;
import java.util.Queue;

public class _02LevelOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Level Order Traversal :");
        levelOrderTraversal(root);

        System.out.println("\nLevel Order Traversal by level by level :");
        levelOrderTraversalLevelByLevel(root);

        System.out.println("\nLevel Order Traversal by level by level Method 2 :");
        levelOrderTraversalLevelByLevelMethod2(root);
    }

    public static void levelOrderTraversal(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.key+" ");
            if (current.left != null){
                queue.offer(current.left);
            }
            if (current.right != null){
                queue.offer(current.right);
            }
        }
    }


    public static void levelOrderTraversalLevelByLevel(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() > 1){
            Node current = queue.poll();
            if (current == null){
                System.out.println(); // To print new line
                queue.add(null);
                continue;
            }
            System.out.print(current.key+" ");
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
    }


    public static void levelOrderTraversalLevelByLevelMethod2(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            for (int i=0;i<count;i++){
                Node current = queue.poll();
                System.out.print(current.key+" ");
                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            System.out.println();  //To print new line.
        }
    }
}
