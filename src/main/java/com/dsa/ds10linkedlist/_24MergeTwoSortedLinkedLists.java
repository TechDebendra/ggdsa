package com.dsa.ds10linkedlist;

public class _24MergeTwoSortedLinkedLists {

    public static Node merge(Node h1, Node h2){
        if (h1 == null){
            return h2;
        }

        if (h2 == null){
            return h1;
        }
        Node head = null, tail = null;

        if (h1.data <= h2.data){
            head = tail = h1;
            h1 = h1.next;
        }else {
            head = tail = h2;
            h2 = h2.next;
        }

        while (h1 != null && h2 != null){
            if (h1.data <= h2.data){
                tail.next = h1;
                tail = h1;
                h1 = h1.next;
            }else {
                tail.next = h2;
                tail = h2;
                h2 = h2.next;
            }
        }

       if (h1 == null){
           tail.next = h2;
       }else {
           tail.next = h1;
       }

       return head;
    }

    public static Node recursiveMerge(Node h1, Node h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        if (h1.data <= h2.data) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }
}
