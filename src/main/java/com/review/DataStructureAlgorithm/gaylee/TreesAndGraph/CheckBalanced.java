package com.review.DataStructureAlgorithm.gaylee.TreesAndGraph;

public class CheckBalanced {
    public static void main(String args[]) {
        Node root = new Node(5);
        root.leftChild = new Node(6);
        root.rightChild = new Node(8);

        root.leftChild.leftChild = new Node(6);
        root.leftChild.rightChild = new Node(9);

        root.rightChild.leftChild = new Node(7);
        root.rightChild.rightChild = new Node(8);
        root.rightChild.rightChild.rightChild = new Node(10);
        root.rightChild.rightChild.rightChild.rightChild = new Node(11);

        boolean result = isBalanced(root);
        System.out.println(result);
    }

    public static boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int heightOfLeft = getHeight(node.leftChild);
        int heightOfRight = getHeight(node.rightChild);

        if (Math.abs(heightOfLeft - heightOfRight) > 1) {
            return false;
        }

        return true;
    }

    public static int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
    }

}
