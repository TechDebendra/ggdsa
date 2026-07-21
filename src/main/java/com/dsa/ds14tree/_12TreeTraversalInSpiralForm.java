package com.dsa.ds14tree;

import java.util.*;

public class _12TreeTraversalInSpiralForm {

    /*public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Spiral Reverse : Method 1 (Queue + Stack )");
        spiralTraversal(root);
        System.out.println("\nSpiral Reverse : Method 2 (Stack + Stack )");
        spiralTraversal2(root);

        System.out.println("\nSpiral Reverse : Method 3 (Dequeue)");
        spiralTraversal3(root);

    }*/

    //Method - 1
    public static void spiralTraversal(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        Deque<Integer> stack = new ArrayDeque<>();

        while (!queue.isEmpty()){
            int count = queue.size();

            for (int i= 0; i<count; i++){
                Node current = queue.poll();
                if (reverse){
                    stack.push(current.key);
                }else{
                    System.out.print(current.key+" ");
                }
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }

            if (reverse){
                while (!stack.isEmpty()){
                    System.out.print(stack.pop()+" ");
                }
            }
            reverse = !reverse;

        }

    }

    //Method - 2
    public static void spiralTraversal2(Node root){
        if (root == null){
            return;
        }

        Deque<Node> s1 = new ArrayDeque<>();
        Deque<Node> s2 = new ArrayDeque<>();

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()){
                Node current = s1.pop();
                System.out.print(current.key+" ");
                if (current.left != null){
                    s2.push(current.left);
                }

                if (current.right != null){
                    s2.push(current.right);
                }
            }

            while (!s2.isEmpty()){
                Node current = s2.pop();
                System.out.print(current.key+" ");

                if (current.right != null){
                    s1.push(current.right);
                }
                if (current.left != null){
                    s1.push(current.left);
                }
            }
        }

    }

    //Method - 3
    public static void spiralTraversal3(Node root) {
        if (root == null) {
            return;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean reverse = false;

        while (!deque.isEmpty()){
            int size = deque.size();
            Node current;
            if (reverse){
                while (size > 0){
                    current = deque.pollLast();
                    System.out.print(current.key+" ");
                    if (current.right != null){
                        deque.offerFirst(current.right);
                    }
                    if (current.left != null){
                        deque.offerFirst(current.left);
                    }

                    size--;
                }
                reverse = false;
            }else {
                while (size > 0){
                    current = deque.pollFirst();
                    System.out.print(current.key+" ");
                    if (current.left != null){
                        deque.offerLast(current.left);
                    }
                    if (current.right != null){
                        deque.offerLast(current.right);
                    }

                    size--;
                }
                reverse = true;
            }
        }
    }

    public static void main(String[] args) {

        Node root = null;

        // ============================================================
        // Test Case 1 : Single Node
        // Expected : 1
        // ============================================================

      /*  root = new Node(1);*/

        // ============================================================
        // Test Case 2 : Left Skewed Tree
        // Expected : 1 2 3 4
        // ============================================================

/*        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);*/

        // ============================================================
        // Test Case 3 : Right Skewed Tree
        // Expected : 1 2 3 4
        // ============================================================

/*        root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);*/

        // ============================================================
        // Test Case 4 : Perfect Binary Tree
        // Expected : 1 3 2 4 5 6 7
        // ============================================================

        /*root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
*/
        // ============================================================
        // Test Case 5 : Perfect Binary Tree (4 Levels)
        // Expected :
        // 1 3 2 4 5 6 7 15 14 13 12 11 10 9 8
        // ============================================================
/*

        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);

        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
*/

        // ============================================================
        // Test Case 6 : Incomplete Tree
        // Expected :
        // 1 3 2 4 5 6 9 8 7
        // ============================================================
/*

        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.right.left = new Node(5);
        root.right.right = new Node(6);

        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);

        root.right.right.left = new Node(9);
*/

        // ============================================================
        // Test Case 7 : Random Missing Nodes
        // Expected :
        // 1 3 2 4 5 7 6
        // ============================================================
/*

        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(4);
        root.right.left = new Node(5);

        root.left.right.left = new Node(6);
        root.right.left.right = new Node(7);
*/

        // ============================================================
        // Test Case 8 : Uneven Tree
        // Expected :
        // 1 3 2 4 6 5 7
        // ============================================================

/*        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.left.left.left = new Node(5);
        root.left.left.right = new Node(6);

        root.left.left.right.right = new Node(7);*/

        // ============================================================
        // Test Case 9 : Complex Tree
        // Expected :
        // 1 3 2 4 5 6 7 11 10 9 8 12
        // ============================================================

/*        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);

        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);

        root.right.right.left = new Node(11);

        root.left.right.left.right = new Node(12);*/

        // ============================================================
        // Test Case 10 : Ultimate Stress Test
        // Expected :
        // 10 30 20 40 50 60 70 130 120 110 100 90 80 140 150
        // ============================================================

/*        root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        root.left.left.left = new Node(80);
        root.left.left.right = new Node(90);

        root.left.right.right = new Node(100);

        root.right.left.left = new Node(110);

        root.right.right.left = new Node(120);
        root.right.right.right = new Node(130);

        root.left.left.right.left = new Node(140);

        root.right.right.left.right = new Node(150);

        // ============================================================
*/
        System.out.println("Spiral Traversal:");
        spiralTraversal3(root);
    }
}
