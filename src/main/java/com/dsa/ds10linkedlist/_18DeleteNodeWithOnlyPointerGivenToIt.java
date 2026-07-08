package com.dsa.ds10linkedlist;

public class _18DeleteNodeWithOnlyPointerGivenToIt {
    // Assume the pointer is not pointing to the last node
    public static void deletePointedNode(Node pointer) {

        if (pointer == null || pointer.next == null) {
            throw new IllegalArgumentException(
                    "Pointer cannot be null or point to the last node."
            );
        }

        pointer.data = pointer.next.data;
        pointer.next = pointer.next.next;
    }
}
