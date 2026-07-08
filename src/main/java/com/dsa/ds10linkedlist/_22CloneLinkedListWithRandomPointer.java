package com.dsa.ds10linkedlist;

import java.util.HashMap;

public class _22CloneLinkedListWithRandomPointer {


    //Approach -1:
    public static Node cloneList1(Node head){
        if (head == null){
            return null;
        }

        HashMap<Node,Node> nodeHashMap = new HashMap<>();

        Node current = head;
        while (current != null){
            nodeHashMap.put(current,new Node(current.data));
            current = current.next;
        }

        current = head;

        while (current !=null){
            Node clone = nodeHashMap.get(current);
            clone.next = nodeHashMap.get(current.next);
            clone.random = nodeHashMap.get(current.random);
            current = current.next;
        }

        return nodeHashMap.get(head);
    }

    public static Node cloneList2(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;

        while (current != null){
            Node temp = new Node(current.data);
            temp.next = current.next;
            current.next = temp;
            current = temp.next;
        }

        current = head;

        while (current != null && current.next != null){
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }

        Node newHead = head.next;

        current = head;

        while (current !=null){
            Node temp = current.next;
            current.next = temp.next;
            temp.next = temp.next != null ? temp.next.next: null;
            current = current.next;
        }

        return newHead;
    }
}
