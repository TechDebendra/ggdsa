package com.dsa.ds14tree;

public class _15BurnABinaryTreeFromLeaf {
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

        int[] leaves = {80, 100, 110, 130, 140, 150};

        for (int leaf : leaves) {

            _15BurnABinaryTreeFromLeaf tree = new _15BurnABinaryTreeFromLeaf();

            tree.burnTime(root, leaf, tree.new Distance(-1));

            System.out.println("Leaf : " + leaf +
                    "  Burn Time : " + tree.result);
        }
    }

    public int result=0;

    public int burnTime(Node root,int leaf,Distance dist){
        if (root == null){
            return 0;
        }

        if (root.key == leaf){
            dist.value = 0;
            return 1;
        }

        Distance leftDist = new Distance(-1);
        Distance rightDist = new Distance(-1);

        int leftHeight = burnTime(root.left,leaf,leftDist);
        int rightHeight = burnTime(root.right,leaf,rightDist);

        if (leftDist.value != -1){
            dist.value = leftDist.value + 1;
            result = Math.max(result, dist.value + rightHeight);
        }

        if (rightDist.value != -1){
            dist.value = rightDist.value +1;
            result = Math.max(result,dist.value+leftHeight);
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
    class Distance{
        int value;
        Distance(int value){
            this.value = value;
        }
    }
}
