package com.dsa.ds10linkedlist;

public class _05InsertIntoSortedLinkedList {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original List:");
        printList(head);

        // Insert at beginning
        head = insert(head, 5);
        System.out.println("\nAfter inserting 5:");
        printList(head);

        // Insert in the middle
        head = insert(head, 25);
        System.out.println("\nAfter inserting 25:");
        printList(head);

        // Insert duplicate
        head = insert(head, 30);
        System.out.println("\nAfter inserting 30:");
        printList(head);

        // Insert at end
        head = insert(head, 50);
        System.out.println("\nAfter inserting 50:");
        printList(head);
    }

    public static Node insert(Node head, int data){
        Node temp = new Node(data);
        if (head == null){
            return temp;
        }
        if (data < head.data){
            temp.next = head;
            return temp;
        }

        Node current = head;

        while (current.next != null && data > current.next.data){
            current = current.next;
        }
        temp.next = current.next;
        current.next = temp;

        return head;

    }

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
