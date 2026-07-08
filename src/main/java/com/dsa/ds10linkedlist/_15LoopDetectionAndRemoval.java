package com.dsa.ds10linkedlist;

public class _15LoopDetectionAndRemoval {

    public static Node removeLoop(Node head){
        Node slwPtr = head;
        Node fstPtr = head;

        while (fstPtr != null && fstPtr.next != null){
            slwPtr = slwPtr.next;
            fstPtr = fstPtr.next.next;
            if (slwPtr == fstPtr){
                break;
            }
        }

        if (fstPtr == null || fstPtr.next == null){
            return head;
        }
        slwPtr = head;

        while (slwPtr != fstPtr){
            slwPtr = slwPtr.next;
            fstPtr = fstPtr.next;
        }

        while (fstPtr.next != slwPtr){
            fstPtr = fstPtr.next;
        }

        fstPtr.next = null;

        return head;
    }
}
