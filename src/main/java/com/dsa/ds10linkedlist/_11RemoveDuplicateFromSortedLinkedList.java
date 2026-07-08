package com.dsa.ds10linkedlist;

import static com.dsa.ds10linkedlist._05InsertIntoSortedLinkedList.printList;

public class _11RemoveDuplicateFromSortedLinkedList {

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(20);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(40);
        head.next.next.next.next.next.next = new Node(40);

        System.out.println("Original List:");
        printList(head);

        head = removeDuplicate(head);

        System.out.println("After Removing Duplicates:");
        printList(head);
    }
    public static Node removeDuplicate(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node current = head;

        while (current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            }else {
                current = current.next;
            }

        }

        return head;
    }
}
