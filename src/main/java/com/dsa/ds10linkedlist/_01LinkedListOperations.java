package com.dsa.ds10linkedlist;

public class _01LinkedListOperations {
    public static void main(String[] args) {

        // Creating nodes
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);

        // Linking nodes: 10 -> 20 -> 30
        Node head = n1;
        n1.next = n2;
        n2.next = n3;

        // Original Linked List
        traverse(head);
        // Output:
        // 10 --> 20 --> 30 --> null

        // Insert at the beginning
        head = insertAtFirst(head, 9);
        traverse(head);
        // Output:
        // 9 --> 10 --> 20 --> 30 --> null

        // Recursive Traversal
        System.out.println("Recursive Traversal:");
        recursiveTraverse(head);
        // Output:
        // 9 --> 10 --> 20 --> 30 --> null

        // Reverse Traversal
        System.out.println("\nReverse Traversal:");
        reverseTraverse(head);
        // Output:
        // 30 <-- 20 <-- 10 <-- 9 <--

        // Display current linked list
        System.out.println("\n\nCurrent Linked List:");
        traverse(head);
        // Output:
        // 9 --> 10 --> 20 --> 30 --> null

        // Insert at the end
        System.out.println("Insert 40 at the end.");
        head = insertAtEnd(head, 40);
        traverse(head);
        // Output:
        // 9 --> 10 --> 20 --> 30 --> 40 --> null

        // Insert at the 3rd position
        System.out.println("Insert 15 at the 3rd position.");
        head = insertAtPosition(head, 15, 3);
        traverse(head);
        // Output:
        // 9 --> 10 --> 15 --> 20 --> 30 --> 40 --> null


        head= deleteFromFirst(head);
        traverse(head);

        head = deleteFromLast(head);
        traverse(head);
    }

    public static void traverse(Node head){
        if (head == null){
            System.out.println("Empty linked list!");
            return;
        }
        Node current=head;
        while (current!=null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void recursiveTraverse(Node head){
        if (head==null){
            System.out.println("null");
            return;
        }

        System.out.print(head.data+" --> ");
        recursiveTraverse(head.next);

    }

    public static void reverseTraverse(Node head){
        if (head==null){
            return;
        }

        reverseTraverse(head.next);
        System.out.print(head.data+" <-- ");

    }

    public static Node insertAtFirst(Node head,int data){
        Node temp = new Node(data);
        temp.next=head;
        return temp;
    }

    public static Node insertAtEnd(Node head,int data){
        Node temp = new Node(data);
        if (head == null){
            return temp;
        }
        Node current = head;

        while (current.next != null){
            current = current.next;
        }

        current.next=temp;

        return  head;
    }

    public static Node insertAtPosition(Node head,int data,int position){
        if (position <= 0) {
            throw new IllegalArgumentException("Position must be greater than 0.");
        }
        Node temp = new Node(data);
        if (position==1){
            temp.next = head;
            return temp;
        }
        Node pointer = head;
        for (int i=1;i<=position-2 && pointer!=null;i++){
            pointer = pointer.next;
        }

        if (pointer==null){
            throw new IllegalArgumentException("Invalid position!");
        }
        temp.next = pointer.next;
        pointer.next = temp;

        return head;
    }

    public static Node deleteFromFirst(Node head){
        if (head==null){
            return null;
        }
        return head.next;
    }

    public static Node deleteFromLast(Node head){
        if (head == null || head.next==null ){
            return null;
        }

        Node pointer=head;

        while (pointer.next.next != null){
            pointer = pointer.next;
        }
        pointer.next = null;

        return head;
    }


    public static Node deleteFromPosition(Node head,int position){
        if (position <= 0) {
            throw new IllegalArgumentException("Position must be greater than 0.");
        }
        if (head == null){
            return null;
        }
        if (position ==1 ){
            return head.next;
        }

        Node pointer = head;

        while (position>2 && pointer!=null){
            pointer = pointer.next;
            position--;
        }

        if (pointer ==null || pointer.next==null){
            throw new IllegalArgumentException("Invalid position!");
        }
        pointer.next = pointer.next.next;

        return head;

    }

    public static int search(Node head, int key){

        int position=1;
        while (head !=null){

            if (head.data == key){
                return position;
            }
            position++;
            head=head.next;
        }

        return -1;
    }

    public static int recursiveSearch(Node node,int key){
        if (node == null){
            return -1;
        }
        if (node.data == key){
            return 1;
        }else {
            int res=recursiveSearch(node.next,key);
            return res == -1 ? -1 : res+1;
        }
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

}
