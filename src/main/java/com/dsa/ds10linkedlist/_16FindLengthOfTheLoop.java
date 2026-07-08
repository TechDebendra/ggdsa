package com.dsa.ds10linkedlist;

public class _16FindLengthOfTheLoop {
    public static void main(String[] args) {

        // Test Case 1: No Loop
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);

        System.out.println("Loop Length: " + loopLength(head1));

        // Test Case 2: Loop of length 3
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);
        head2.next.next.next.next = new Node(50);

        // Create loop: 50 -> 30
        head2.next.next.next.next.next = head2.next.next;

        System.out.println("Loop Length: " + loopLength(head2));

        // Test Case 3: Self Loop
        Node head3 = new Node(100);
        head3.next = head3;

        System.out.println("Loop Length: " + loopLength(head3));
    }

    public static int loopLength(Node head){

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return 0;
        }
        int count=1;
        Node temp = fast.next;
        while (temp != slow){
            temp = temp.next;
            count++;
        }

        return count;
    }
}
