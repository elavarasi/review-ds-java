package com.review.DataStructureAlgorithm.gaylee.TreesAndGraph;
//Given a sorted (increasing order) array with unique elements, create a binary search tree with minimum height
public class MinimalTree {
    public static void main(String args[]) {
        int[] input = new int[] {3,5,6,8,9,10,13,14,15};
        Node minTreeRoot = buildMinTree(0, input.length-1, input);
        System.out.println(minTreeRoot);
    }

    private static Node buildMinTree(int start, int end, int[] input) {
        if (end < start) {
            return null;
        }

        int midPoint = (start + end) / 2;
        Node newTreeNode = new Node(midPoint);
        newTreeNode.leftChild = buildMinTree(start, midPoint-1, input);
        newTreeNode.rightChild = buildMinTree(midPoint + 1, end, input);

        return newTreeNode;
    }

    public void printATree(Node node) {

    }


}
