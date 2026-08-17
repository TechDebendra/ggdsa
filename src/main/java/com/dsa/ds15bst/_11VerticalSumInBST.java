package com.dsa.ds15bst;


import java.util.Map;
import java.util.TreeMap;

public class _11VerticalSumInBST {

    public static void verticalSum(Node root){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        verticalSumUtils(root,0,map);

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void verticalSumUtils(Node root, int horizontalDist, TreeMap<Integer,Integer> map){
        if (root == null){
            return;
        }
        verticalSumUtils(root.left,horizontalDist-1,map);

        int sum = map.get(horizontalDist) == null ? 0 : map.get(horizontalDist);
        map.put(horizontalDist,sum+root.data);

        verticalSumUtils(root.right,horizontalDist+1,map);
    }
}
