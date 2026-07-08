package com.dsa.ds10linkedlist;

public class _14LoopDetection_Approach_2 {

    public static void main(String[] args) {
        // Test Case 1: No Loop
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);

        System.out.println("Test Case 1 (No Loop): " + isLoopPresent(head1));

        // Test Case 2: Loop Present
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);
        head2.next.next.next.next = new Node(50);

        // Creating loop: 50 -> 30
        head2.next.next.next.next.next = head2.next.next;

        System.out.println("Test Case 2 (Loop Present): " + isLoopPresent(head2));

        // Test Case 3: Self Loop
        Node head3 = new Node(100);
        head3.next = head3;

        System.out.println("Test Case 3 (Self Loop): " + isLoopPresent(head3));

    }


    //Approach -2:
    public static boolean isLoopPresent(Node head){
        if (head == null){
            return false;
        }

        Node dummy = new Node(0);

        while (head != null){
            if (head.next == dummy){
                return true;
            }
            Node next = head.next;
            head.next = dummy;
            head = next;
        }

        return false;
    }
}
