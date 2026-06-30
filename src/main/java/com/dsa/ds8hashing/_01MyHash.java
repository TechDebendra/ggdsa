package com.dsa.ds8hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class _01MyHash {

    public static void main(String[] args) {

        MyHash hash = new MyHash(10);

        System.out.println("Initially");
        System.out.println(hash);

        System.out.println("\nAdding elements...");
        hash.add(15);
        hash.add(25);
        hash.add(35);
        hash.add(5);
        hash.add(20);
        hash.add(18);
        hash.add(29);
        hash.add(-15);

        System.out.println(hash);

        System.out.println("\nSearching");
        System.out.println("15 : " + hash.search(15));
        System.out.println("20 : " + hash.search(20));
        System.out.println("99 : " + hash.search(99));
        System.out.println("-15 : " + hash.search(-15));

        System.out.println("\nRemoving 25");
        hash.remove(25);
        System.out.println(hash);

        System.out.println("\nRemoving 100 (not present)");
        hash.remove(100);
        System.out.println(hash);

        System.out.println("\nRemoving -15");
        hash.remove(-15);
        System.out.println(hash);

    }

    static class MyHash {

        private int bucket;
        private ArrayList<LinkedList<Integer>> table;

        public MyHash(int bucket) {

            this.bucket = bucket;
            table = new ArrayList<>(bucket);

            for (int i = 0; i < bucket; i++) {
                table.add(new LinkedList<>());
            }
        }

        public void add(int key) {

            int index = (key % bucket + bucket) % bucket;
            table.get(index).add(key);
        }

        public void remove(int key) {

            int index = (key % bucket + bucket) % bucket;
            table.get(index).remove((Integer) key);
        }

        public boolean search(int key) {

            int index = (key % bucket + bucket) % bucket;
            return table.get(index).contains(key);
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bucket; i++) {
                sb.append(i)
                        .append(" -> ")
                        .append(table.get(i))
                        .append("\n");
            }

            return sb.toString();
        }
    }
}