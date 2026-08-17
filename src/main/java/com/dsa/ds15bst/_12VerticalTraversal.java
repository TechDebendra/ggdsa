package com.dsa.ds15bst;

import java.util.*;

public class _12VerticalTraversal {
    static class Pair{
        Node node;
        int hd;

        public Pair(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }


    public static void  verticalTraversal(Node root){
        if (root == null){
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();

        queue.add(new Pair(root,0));

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.hd;

            if (map.containsKey(hd)){
                map.get(hd).add(curr.data);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.data);
                map.put(hd,list);
            }

            if (curr.left != null){
                queue.add(new Pair(curr.left,hd-1));
            }

            if (curr.right != null){
                queue.add(new Pair(curr.right,hd+1));
            }

        }

        for (Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            for (int data : entry.getValue()){
                System.out.println(data);
            }
        }
    }
}
