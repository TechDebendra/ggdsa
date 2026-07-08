package com.dsa.ds10linkedlist;

import java.util.HashSet;

public class _20IntersectionPointOfTwoLinkedList {

    //Approach 1:
    public static int findIntersectionPoint1(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return -1;
        }
        int c1 = 0;
        int c2 = 0;

        Node current = head1;

        while (current != null){
            c1++;
            current = current.next;
        }

        current = head2;

        while (current != null){
            c2++;
            current = current.next;
        }

        int d = Math.abs(c1-c2);
        Node longer = c1>=c2 ? head1 : head2;
        Node shorter = c1 >=c2 ? head2 : head1;

        while (d > 0){
            longer = longer.next;
            d--;
        }

        while (longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }

        return shorter == null ? -1 : shorter.data;
    }

    //Approach 2:
    public static int findIntersectionPoint2(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return -1;
        }

        HashSet<Node> nodeSet = new HashSet<>();
        Node current = head1;
        while (current != null){
            nodeSet.add(current);
            current = current.next;
        }

        current = head2;

        while (current != null){
            if (nodeSet.contains(current)){
                return current.data;
            }
            current = current.next;
        }

        return -1;

    }

    //Approach 3:
    public static int findIntersectionPoint3(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return -1;
        }

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2){
            p1 = (p1 == null) ? head2 : p1.next;
            p2 = (p2 == null) ? head1 : p2.next;
        }

        return p1 == null ? -1 : p1.data;
    }

}
