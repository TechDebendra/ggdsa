package com.dsa.ds14tree;

import java.util.LinkedList;
import java.util.Queue;

public class _09MaxWidthOfTree {

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Max width is : "+maxWidth(root));

    }

    public static int maxWidth(Node root){
        if (root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int result =0;
        queue.add(root);

        while (!queue.isEmpty()){
            int count = queue.size();
            result = Math.max(result, count);

            for (int i=0 ;i< count; i++){
                Node current = queue.poll();
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
        }
        return result;
    }
}
