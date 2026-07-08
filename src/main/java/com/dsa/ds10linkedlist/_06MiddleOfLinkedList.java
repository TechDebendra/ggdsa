package com.dsa.ds10linkedlist;

import static com.dsa.ds10linkedlist._05InsertIntoSortedLinkedList.printList;

public class _06MiddleOfLinkedList {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.print("List: ");
        printList(head);

        middleOfLinkedList(head);

        // Even number of nodes
        head.next.next.next.next = null;

        System.out.print("\nList: ");
        printList(head);

        middleOfLinkedList(head);

        // Single node
        Node single = new Node(100);

        System.out.print("\nList: ");
        printList(single);

        middleOfLinkedList(single);

        // Empty list
        System.out.println();
        middleOfLinkedList(null);
    }


    public static void middleOfLinkedList(Node head){
        if (head == null ){
            System.out.println("The list is empty!");
            return;
        }

        Node slowPtr = head;
        Node fastPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        System.out.println("Middle node is :"+slowPtr.data);
    }
}
