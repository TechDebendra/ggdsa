package com.dsa.ds10linkedlist;

import static com.dsa.ds10linkedlist._05InsertIntoSortedLinkedList.printList;

public class _19SegregateEvenAndOddNodes {
    public static void main(String[] args) {

        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        head = segregateEvenOdd(head);

        System.out.println("After Segregating Even and Odd:");
        printList(head);
    }

    public static Node segregateEvenOdd(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;

        Node current = head;

        while (current != null){
            if (current.data % 2 == 0){
                if (evenStart == null){
                    evenStart = current;
                    evenEnd = current;
                }else {
                    evenEnd.next = current;
                    evenEnd = current;
                }
            }else {
                if (oddStart == null){
                    oddStart = current;
                    oddEnd = current;
                }else {
                    oddEnd.next = current;
                    oddEnd = current;
                }
            }

            current = current.next;

        }

        if (evenStart == null || oddStart == null){
            return head;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }
}
