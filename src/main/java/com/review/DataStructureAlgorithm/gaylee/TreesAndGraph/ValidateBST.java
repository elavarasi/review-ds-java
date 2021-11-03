package com.review.DataStructureAlgorithm.gaylee.TreesAndGraph;

public class ValidateBST {
    static int index = 0;
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

        System.out.println(isValidateBST(root));

    }

    public static boolean isValidateBST(Node node) {
        int[] inOrderTraversalArray = new int[20];
        traverseTree(node, inOrderTraversalArray);
        for (int i = 1; i< inOrderTraversalArray.length; i++) {
            if (inOrderTraversalArray[i] < inOrderTraversalArray[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void traverseTree(Node root, int[] arr) {
        if (root == null) {
            return;
        }

        traverseTree(root.leftChild, arr);
        arr[index] = root.getNodeVal();
        index ++;
        traverseTree(root.rightChild, arr);

    }

}
