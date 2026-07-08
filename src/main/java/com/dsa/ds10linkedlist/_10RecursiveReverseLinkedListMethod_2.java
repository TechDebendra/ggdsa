package com.dsa.ds10linkedlist;

import static com.dsa.ds10linkedlist._05InsertIntoSortedLinkedList.printList;

public class _10RecursiveReverseLinkedListMethod_2 {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original List:");
        printList(head);

        head = reverse(head, null);

        System.out.println("Reversed List:");
        printList(head);
    }

    public static Node reverse(Node current,Node prev){
        if (current == null){
            return prev;
        }
        Node temp = current.next;
        current.next = prev;
        return reverse(temp,current);
    }
}
