package com.dsa.ds10linkedlist;

public class _03SingleCircularLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node n1 = new Node(20);
        Node n2 = new Node(30);
        head.next = n1;
        n1.next = n2;
        n2.next = head;

        traverse(head);
        traverse2(head);
    }

    public static void traverse(Node head){
        if (head == null){
            return;
        }

        Node temp = head.next;
        System.out.print(head.data+" --> ");
        while (temp != head){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public static void traverse2(Node head){
        if (head == null){
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }while (temp != head);
        System.out.println("null");

    }

    //Naive approach
    public static Node insertAtBeginning(Node head,int data){
        Node temp = new Node(data);
        if (head == null){
            temp.next = temp;
            return temp;
        }

        Node current = head;
        while (current.next != head){
            current = current.next;
        }

        current.next = temp;
        temp.next = head;

        return temp;
    }
    //Efficient approach
    public  static Node insertAtBeginning1(Node head,int data){
        Node temp = new Node(data);

        if (head == null){
            temp.next = temp;
            return temp;
        }
        temp.next = head.next;
        head.next = temp;
        int x = head.data;
        head.data = temp.data;
        temp.data = x;
        return head;
    }
    //Insert at end
    public static Node insertAtEnd(Node head,int data){
        Node temp = new Node(data);
        if (head == null){
            temp.next = temp;
            return temp;
        }
        temp.next = head.next;
        head.next = temp;

        int x = head.data;
        head.data = temp.data;
        temp.data = x;

        return temp;
    }

    public static Node deleteHead(Node head){
        if (head == null || head.next == head){
            return null;
        }

        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    public static Node deleteAtKthPosition(Node head,int k){
        if (k<=0){
            throw new IllegalArgumentException("Invalid position.");
        }

        if (head == null) {
            return null;
        }

        if (k == 1){
            return deleteHead(head);
        }

        Node current = head;
        for (int i=1;i<k-1;i++){
            current = current.next;
            if (current == head){
                throw new IllegalArgumentException("Position out of range.");
            }
        }
        //To avoid deletion of head node while k = total node +1
        if (current.next == head){
            throw new IllegalArgumentException("Position out of range.");
        }

        current.next = current.next.next;
        return head;
    }


}
