package com.dsa.ds15bst;

import java.util.HashSet;
import java.util.Set;

public class _10PairSumInBST {

    public static boolean isPairSum(Node root,int sum){
        HashSet<Integer> set = new HashSet<>();
        return isPairSumUtils(root,sum,set);
    }
    public static boolean isPairSumUtils(Node root, int sum, Set<Integer> set){
        if (root == null){
            return false;
        }
        if (isPairSumUtils(root.left,sum,set)){
            return true;
        }
        if (set.contains(sum-root.data)){
            return true;
        }
        set.add(root.data);
        return isPairSumUtils(root.right,sum,set);
    }
}
