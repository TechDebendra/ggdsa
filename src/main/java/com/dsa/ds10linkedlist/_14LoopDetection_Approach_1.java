package com.dsa.ds10linkedlist;

import java.util.HashSet;

public class _14LoopDetection_Approach_1 {
    public static void main(String[] args) {

        // Test Case 1: No Loop
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);

        System.out.println("Test Case 1 (No Loop): " + isLoopFound_1(head1));

        // Test Case 2: Loop Present
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);
        head2.next.next.next.next = new Node(50);

        // Creating loop: 50 -> 30
        head2.next.next.next.next.next = head2.next.next;

        System.out.println("Test Case 2 (Loop Present): " + isLoopFound_1(head2));

        // Test Case 3: Self Loop
        Node head3 = new Node(100);
        head3.next = head3;

        System.out.println("Test Case 3 (Self Loop): " + isLoopFound_1(head3));

        // Test Case 4: Empty List
        Node head4 = null;

        System.out.println("Test Case 4 (Empty List): " + isLoopFound_1(head4));
    }

    //Approach -1
    public static boolean isLoopFound_1(Node head){
        if (head == null){
            return false;
        }

        HashSet<Node> nodeSet = new HashSet<>();
        Node current = head;
        while (current != null){
            if (nodeSet.contains(current)){
                return true;
            }
            nodeSet.add(current);
            current = current.next;
        }

        return false;
    }

}
