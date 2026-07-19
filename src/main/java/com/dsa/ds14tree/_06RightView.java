package com.dsa.ds14tree;

import java.util.LinkedList;
import java.util.Queue;

public class _06RightView {

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Right View : ");
        rightView(root);

        System.out.println("\nRight View : ");
        recursiveRightView(root,1 );
    }

    public static void rightView(Node root){
        if (root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
           int count = queue.size();

           for (int i=0;i<count;i++){
               Node current = queue.poll();
               if (i == count-1){
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

    public static int maxLevel = 0;
    public static void recursiveRightView(Node root, int level){
        if (root == null){
            return;
        }
        if (maxLevel < level){
            System.out.print(root.key+" ");
            maxLevel = level;
        }
        recursiveRightView(root.right,level+1);
        recursiveRightView(root.right,level+1);
    }
}
