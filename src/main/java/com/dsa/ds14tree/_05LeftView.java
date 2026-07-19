package com.dsa.ds14tree;

import java.util.LinkedList;
import java.util.Queue;

public class _05LeftView {
    public static int maxLevel = 0;

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Left View : ");
        leftView(root);

        System.out.println("\nLeft View : ");
        recursiveLeftView(root,1 );
    }


    public static void leftView(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            for (int i=0;i<count;i++){
                Node current = queue.poll();
                if (i == 0){
                    System.out.print(current.key+" ");
                }
                if (current.left != null){
                    queue.add(current.left);
                }

                if (current.right != null){
                    queue.add(current.right);
                }
            }
        }

    }


    public static void recursiveLeftView(Node root, int level){
        if (root == null){
            return;
        }

        if (maxLevel < level){
            System.out.print(root.key+" ");
            maxLevel = level;
        }

        recursiveLeftView(root.left,level+1 );
        recursiveLeftView(root.right,level+1);

    }
}
