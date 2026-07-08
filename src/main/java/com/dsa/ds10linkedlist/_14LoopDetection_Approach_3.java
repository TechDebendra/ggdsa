package com.dsa.ds10linkedlist;

public class _14LoopDetection_Approach_3 {

    public static void main(String[] args) {

        // Test Case 1: No Loop
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);

        System.out.println("No Loop: " + isLoopDetected(head1));

        // Test Case 2: Loop Present
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);
        head2.next.next.next.next = new Node(50);

        // Create loop: 50 -> 30
        head2.next.next.next.next.next = head2.next.next;

        System.out.println("Loop Present: " + isLoopDetected(head2));

        // Test Case 3: Self Loop
        Node head3 = new Node(100);
        head3.next = head3;

        System.out.println("Self Loop: " + isLoopDetected(head3));

        // Test Case 4: Empty List
        System.out.println("Empty List: " + isLoopDetected(null));
    }

    public static boolean isLoopDetected(Node head){
        Node fastPtr = head;
        Node slowPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if ( fastPtr == slowPtr){
                return true;
            }
        }

        return false;
    }
}
