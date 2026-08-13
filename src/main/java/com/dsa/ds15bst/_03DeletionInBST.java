package com.dsa.ds15bst;

public class _03DeletionInBST {

    public Node delete(Node root, int key){
        if (root == null){
            return null;
        }
        if (key < root.data){
            root.left = delete(root.left,key);
        }else if (key > root.data){
            root.right = delete(root.right, key);
        }else {  // key == root.data
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }
            Node successor = getSuccessor(root);
            root.data = successor.data;
            root.right = delete(root.right,successor.data);

        }

        return root;
    }


    public Node getSuccessor(Node root){
        Node curr = root.right;

        while (curr != null && curr.left != null){
            curr = curr.left;
        }

        return curr;
    }
}
