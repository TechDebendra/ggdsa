package com.dsa.ds14tree;

import java.util.HashMap;
import java.util.Map;

public class _11ConstructBinaryTreeFromInorderAndPreorderOptimised {

    private static int preIndex = 0;

    public static Node constructTree(int[] inOrder, int[] preOrder) {

        preIndex = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        return constructTree( preOrder, 0, inOrder.length - 1, map);
    }

    private static Node constructTree(int[] preOrder,
                                      int start,
                                      int end,
                                      Map<Integer, Integer> map) {

        if (start > end) {
            return null;
        }

        Node root = new Node(preOrder[preIndex++]);

        if (start == end) {
            /*
            * Without the check → Still correct, but performs a few unnecessary recursive calls
            * on leaf nodes. Time complexity remains O(n) in both cases, because each extra call
            * immediately returns due to the start > end base case.
            * */
            return root;
        }

        int index = map.get(root.key);

        root.left = constructTree(preOrder, start, index - 1, map);
        root.right = constructTree(preOrder, index + 1, end, map);

        return root;
    }
}