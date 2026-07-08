package com.dsa.ds10linkedlist;

import static com.dsa.ds10linkedlist._05InsertIntoSortedLinkedList.printList;

public class _09RecursiveReverseLinkedList {

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original List:");
        printList(head);

        head = recursiveReverse(head);

        System.out.println("Reversed List:");
        printList(head);
    }


    public static Node recursiveReverse(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node restHead = recursiveReverse(head.next);
        Node restTail = head.next;
        restTail.next = head;
        head.next = null;

        return restHead;
    }
}
