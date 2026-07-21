package com.dsa.ds14tree;

import java.util.ArrayList;

public class _17SerializeAndDeserializeABinaryTree {

    public int index = 0;
    public static final int EMPTY = -1;

    public void serialize(Node root, ArrayList<Integer> list){
        if (root == null){
            list.add(EMPTY);
            return;
        }
        list.add(root.key);

        serialize(root.left,list);
        serialize(root.right,list);

    }

    public Node deserialize(ArrayList<Integer> list){
        if (index == list.size()){
            return null;
        }
        int val = list.get(index);
        index++;

        if (val == EMPTY){
            return null;
        }

        Node root = new Node(val);

        root.left = deserialize(list);
        root.right = deserialize(list);

        return root;
    }
}
