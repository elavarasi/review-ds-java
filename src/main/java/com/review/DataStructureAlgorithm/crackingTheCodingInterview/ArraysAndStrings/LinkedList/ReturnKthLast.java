package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.LinkedList;

public class ReturnKthLast {
    public static void main(String args[]) {
        Node root = new Node(5);
        root.next = new Node(6);
        root.next.next = new Node(8);
        root.next.next.next = new Node(6);
        int k = 3;
        Node result = null;

        Node[] nodeArray = new Node[]{result};

        System.out.println(result);
        findkthnode(root, nodeArray, k);
        System.out.println(nodeArray[0].data);
    }

    /* Recursive approach */
    public static int findkthnode(Node node, Node[] nodeArray, int k) {
        if (node == null) {
            return 0;
        } else {
            int previousCount = findkthnode(node.next, nodeArray, k);
            if (previousCount == k) {
                nodeArray[0] = node;
            }
            return previousCount + 1;
        }
    }
}
