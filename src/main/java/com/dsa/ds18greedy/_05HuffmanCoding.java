package com.dsa.ds18greedy;

import java.util.PriorityQueue;

public class _05HuffmanCoding {
    static class Node{
        char ch;
        int freq;
        Node left;
        Node right;
        public Node(char ch, int freq, Node left, Node right){
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    public static void printHuffmanCodes(char[] chars, int[] frequencies){
        if (chars.length != frequencies.length){
            throw new IllegalArgumentException("Invalid Input");
        }

        PriorityQueue<Node> minheap = new PriorityQueue<>((a,b)->a.freq-b.freq);

        for (int i = 0 ; i < chars.length ; i++){
            minheap.add(new Node(chars[i],frequencies[i],null,null ));
        }

        while (minheap.size() > 1){
            Node left = minheap.poll();
            Node right = minheap.poll();
            minheap.add(new Node('$', left.freq+ right.freq,left,right ));
        }

        recursivePrint(minheap.peek(),"");
    }

    public static void recursivePrint(Node root, String s){
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            System.out.println(root.ch+" "+s);
        }
        recursivePrint(root.left,s+"0");
        recursivePrint(root.right,s+"1");

    }

    public static void main(String[] args) {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        printHuffmanCodes(charArray,charfreq);
    }
}
