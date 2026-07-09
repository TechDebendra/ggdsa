package com.dsa.ds10linkedlist;

import java.util.Stack;

public class _25PalindromeLinkedList {



    //Approach -1:
    public static boolean isPalindrome_1(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        Node current = head;

        while (current != null){
            stack.push(current.data);
            current = current.next;
        }

        current = head;

        while (current != null){
            if ( current.data != stack.pop()){
                return false;
            }
            current = current.next;
        }
        return true;
    }

    //Approach -2:
    public static boolean isPalindrome(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node rev = reverse(slow.next);

        slow = head;
        while (rev != null){
            if (rev.data != slow.data){
                return false;
            }
            slow = slow.next;
            rev = rev.next;
        }

        return true;
    }

    public static Node reverse(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node prev = null;
        Node current = head;

        while (current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }

        return prev;
    }

}
