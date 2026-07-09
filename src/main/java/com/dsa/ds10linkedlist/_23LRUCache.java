package com.dsa.ds10linkedlist;

import java.util.HashMap;
import java.util.Map;

public class _23LRUCache {
    private final int capacity;
    private final Map<Integer,Node> nodeMap;
    private final Node head;
    private final Node tail;

    public _23LRUCache(int capacity){
        if (capacity<=0){
            throw new IllegalArgumentException("Invalid capacity!");
        }
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;

    }

    public void addAfterHead(Node node){
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key){
        Node cacheNode = nodeMap.get(key);
        if (cacheNode == null){
            return -1;
        }

        remove(cacheNode);
        addAfterHead(cacheNode);

        return cacheNode.data;
    }

    public void put(int key, int value){
        Node node = nodeMap.get(key);
        if ( node != null){
            node.data = value;
            remove(node);
            addAfterHead(node);
            nodeMap.put(key,node);
        }else {
            if (nodeMap.size() >= capacity){
                Node lru = tail.prev;
                remove(lru);
                nodeMap.remove(lru.key);
            }
            node = new Node(key,value);
            addAfterHead(node);
            nodeMap.put(key,node);

        }
    }

    public void display(){
        Node current = head.next;

        while (current != tail){
            System.out.println("Key : "+current.key+" Value : "+ current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        _23LRUCache cache = new _23LRUCache(3);
        cache.display();

        System.out.println(cache.get(10));  // -1

        cache.put(10,230);
        cache.display();

        System.out.println(cache.get(10));  // 230

        cache.put(20,340);
        cache.display();

        System.out.println(cache.get(10));  // 230
        cache.display();

        System.out.println(cache.get(20));  // 230
        cache.display();

        System.out.println("Adding 30....");
        cache.put(30,312);
        cache.display();

        System.out.println(cache.get(20));  // 230
        cache.display();

        System.out.println("Adding 40....");
        cache.put(40,400);
        cache.display();

    }
}
