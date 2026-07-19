package com.dsa.ds14tree;

import java.util.HashMap;
import java.util.Map;

public class _11ConstructBinaryTreeFromInorderAndPreorder {


    public static int preIndex = 0;
    public static Node constructTreeFromInOrderPreOrder(int[] inOrder, int[] preOrder, int start, int end){
        if (start > end){
            return null;
        }

        Node root = new Node(preOrder[preIndex++]);
        int index = 0;
        for (int i = start; i<= end ; i++){
            if (root.key == inOrder[i]){
                index = i;
                break;
            }
        }
        root.left = constructTreeFromInOrderPreOrder(inOrder,preOrder,start, index-1);
        root.right = constructTreeFromInOrderPreOrder(inOrder,preOrder,index+1,end);

        return root;
    }

}
