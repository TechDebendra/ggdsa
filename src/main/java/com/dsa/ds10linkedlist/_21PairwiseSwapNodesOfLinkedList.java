package com.dsa.ds10linkedlist;

public class _21PairwiseSwapNodesOfLinkedList {

    //Approach -1:
    public static Node pairedSwap1(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node current = head;

        while (current != null && current.next != null){
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
        return head;
    }

    //Approach -2:
    public static Node pairedSwap2(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node currentPair = head.next.next;
        Node prevTail = head;
        head = head.next;
        head.next = prevTail;

        while (currentPair != null && currentPair.next != null){
            prevTail.next = currentPair.next;
            prevTail = currentPair;

            Node temp = currentPair.next.next;
            currentPair.next.next = currentPair;
            currentPair = temp;

        }

        prevTail.next = currentPair;

        return head;
    }
}

