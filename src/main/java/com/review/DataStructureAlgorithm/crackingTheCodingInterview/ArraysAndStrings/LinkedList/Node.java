package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.LinkedList;

public class Node {
    Node next;
    int data;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    public void printAllNodeData(Node node) {
        Node currentNode = node;
        while(currentNode != null) {
            System.out.print(currentNode.data);
            System.out.print(" -> ");
            currentNode = currentNode.next;
        }
        System.out.print(currentNode);
        System.out.println("\n**************");
    }
}
