package com.dsa.ds15bst;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _14BottomViewOfBST {
    static class Pair{
        Node node;
        int hd;
        public  Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void bottomView(Node root){
        if (root == null){
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        queue.add(new Pair(root,0));

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.hd;

            map.put(hd,curr.data);

            if (curr.left != null){
                queue.add(new Pair(curr.left,hd-1));
            }
            if (curr.right != null){
                queue.add(new Pair(curr.right,hd+1));
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }
    }

}
