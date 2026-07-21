package com.dsa.ds14tree;

import java.util.ArrayList;

public class _14FindingLCAInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        root.left.left.left = new Node(80);
        root.left.left.right = new Node(90);

        root.left.right.right = new Node(100);

        root.right.left.left = new Node(110);

        root.right.right.left = new Node(120);
        root.right.right.right = new Node(130);

        root.left.left.right.left = new Node(140);

        root.right.right.left.right = new Node(150);

        Node result1 = findLCA(root,140,100) ;
        if (result1 != null){
            System.out.println("LCA of 140 and 100 : "+result1.key);
        }else {
            System.out.println("No LCA for the given nodes.");
        }

    }

    // Method - 1 :
    public static Node findLCA(Node root,int key1, int key2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!findPath(root,path1,key1) || !findPath(root,path2,key2)){
            return null;
        }

        int i = 0;

        while (i < path1.size() &&
                i < path2.size() &&
                path1.get(i).key == path2.get(i).key) {
            i++;
        }

        return path1.get(i - 1);
    }

    public static boolean findPath(Node root, ArrayList<Node> path, int key){
        if (root == null){
            return false;
        }
        path.add(root);
        if (root.key == key){
            return true;
        }
        if (findPath(root.left,path,key) || findPath(root.right,path,key)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    // Method - 2 :
    public Node lca(Node root,int n1,int n2){
        if (root == null){
            return null;
        }
        if (root.key == n1 || root.key == n2){
            return root;
        }
        Node left = lca(root.left,n1,n2);
        Node right = lca(root.right,n1,n2);

        if (left != null && right != null){
            return root;
        }

        if (left!=null){
            return left;
        }else {
            return right;
        }
    }


}
