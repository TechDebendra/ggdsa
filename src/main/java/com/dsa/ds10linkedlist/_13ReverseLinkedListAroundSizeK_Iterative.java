package com.dsa.ds10linkedlist;

import static com.dsa.ds10linkedlist._05InsertIntoSortedLinkedList.printList;

public class _13ReverseLinkedListAroundSizeK_Iterative {

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println("Original List:");
        printList(head);

        head = reverseK(head, 3);

        System.out.println("After Reversing in Groups of 3:");
        printList(head);
    }
    public static Node reverseK(Node head, int k){
        Node current = head;
        Node prevFirst = null;
        boolean isFirstPass = true;

        while (current != null){
            Node first = current;
            Node prev = null;
            int count = 0;

            while (current!=null && count < k) {
                Node temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
                count++;
            }

            if (isFirstPass){
                head = prev;
                isFirstPass = false;
            }else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }

        return head;
    }
}
