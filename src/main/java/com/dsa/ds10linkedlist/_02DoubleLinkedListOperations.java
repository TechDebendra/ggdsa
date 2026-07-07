package com.dsa.ds10linkedlist;

public class _02DoubleLinkedListOperations {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        head.next = n2;
        n2.prev = head;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        traverse(head);
        System.out.println("Insert 5 at beginning.");
        head = insertAtBeginning(head,5);
        traverse(head);

        System.out.println("Insert 50 at the end.");
        head = insertAtEnd(head,50);
        traverse(head);

        System.out.println("Delete first node.");
        head = deleteFirst(head);
        traverse(head);

        System.out.println("Delete last node.");
        head = deleteLastNode(head);
        traverse(head);

        System.out.println("Reverse Double Linked List.");
        head = reverse(head);
        traverse(head);
    }

    public static void traverse(Node head){
        if (head == null){
            return;
        }
        System.out.println("List :");
        Node current = head;
        while (current!=null){
            System.out.print(current.data+" <--> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static Node insertAtBeginning(Node head,int data){
        Node temp = new Node(data);

        if (head == null ){
            return temp;
        }

        temp.next = head;
        head.prev = temp;

        return temp;
    }

    public static Node insertAtEnd(Node head, int data){
        Node temp = new Node(data);
        if (head == null){
            return  temp;
        }

        Node current = head;

        while (current.next != null){
            current = current.next;
        }
        current.next = temp;
        temp.prev = current;

        return head;
    }

    public static Node deleteFirst(Node head){
        if (head == null || head.next == null){
            return  null;
        }
        head.next.prev = null;
        return head.next;
    }

    public static Node deleteLastNode(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node current = head;

        while (current.next != null){
            current = current.next;
        }

        current.prev.next = null;
        current.prev = null;

        return head;
    }

    public static Node reverse(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node current = head;

        while (current != null){
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }

        return prev.prev;
    }

    public static Node insertAtPosition(Node head, int data, int position){
        if (position <= 0){
            throw new IllegalArgumentException("Invalid Position!");
        }

        if (position == 1){
            return insertAtBeginning(head,data);
        }

        Node current = head;

        for (int i=1;i<position-1 && current!=null;i++){
            current = current.next;
        }
        if (current == null){
            throw new IllegalArgumentException("Invalid Position!");
        }
        Node temp = new Node(data);

        temp.next = current.next;
        if (current.next != null){
            current.next.prev = temp;
        }

        current.next = temp;
        temp.prev = current;

        return head;

    }

    public static Node deleteFromPosition(Node head, int position){
        if (position <= 0){
            throw new IllegalArgumentException("Invalid Position!");
        }

        if (position ==1 ){
            return deleteFirst(head);
        }

        Node current = head;

        for (int i=1;i<position && current!=null;i++){
            current = current.next;
        }
        if (current == null){
            throw new IllegalArgumentException("Invalid Position!");
        }
        current.prev.next = current.next;
        if (current.next != null){
            current.next.prev = current.prev;
        }

        return head;
    }

}
