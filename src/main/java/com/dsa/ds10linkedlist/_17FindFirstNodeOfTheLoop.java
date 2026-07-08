package com.dsa.ds10linkedlist;

public class _17FindFirstNodeOfTheLoop {
    public static void main(String[] args) {

        // Test Case 1: No Loop
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);

        System.out.println("First Node of Loop: " + findFirstNode(head1));

        // Test Case 2: Loop starts at 30
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);
        head2.next.next.next.next = new Node(50);

        // Create loop: 50 -> 30
        head2.next.next.next.next.next = head2.next.next;

        System.out.println("First Node of Loop: " + findFirstNode(head2));

        // Test Case 3: Self Loop
        Node head3 = new Node(100);
        head3.next = head3;

        System.out.println("First Node of Loop: " + findFirstNode(head3));
    }
    public static int findFirstNode(Node head){
        Node slow = head;
        Node fast = head;

        while ( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                break;
            }
        }

        if (fast == null || fast.next == null){
            return -1;
        }

        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
}
