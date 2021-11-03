package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.LinkedList;

public class DeleteNodeInALinkedList {
    public static void main(String args[]) {
        Node root = new Node(5);
        root.next = new Node(6);
        root.next.next = new Node(8);
        root.next.next.next = new Node(6);

        root.printAllNodeData(root);
        deleteNodeInALinkedList(root);

        root.printAllNodeData(root);
    }

    public static void deleteNodeInALinkedList(Node node) {
        if (node != null && node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }
}