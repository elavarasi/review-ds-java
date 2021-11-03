package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.LinkedList;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */

public class Partition {
    public static void main(String args[]) {
        Node root = new Node(1);
//        root.next = new Node(1);
        root.next = new Node(4);
        root.next.next = new Node(3);
        root.next.next.next = new Node(2);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(2);


        int x = 3;
        root.printAllNodeData(root);
        Node result = partition(root, x);
        root.printAllNodeData(result);

    }

    private static Node partition(Node root, int x) {
        if (root == null) {
            return root;
        }

        if (root.next == null) {
            return root;
        }

        Node resultHead = new Node(root.data);
        Node resultTail = null;


        Node currentNode = root.next;
        while (currentNode != null) {
            if (currentNode.data < x) {
                    Node newNode = new Node(resultHead.data);
                    resultHead.data = currentNode.data;
                    newNode.next = resultHead;
                    resultHead = newNode;
            } else {
                {
                    Node newNode = new Node(currentNode.data);
                    if (resultTail == null) {
                        resultTail = newNode;
                        resultTail.next = null;
                        resultHead.next = resultTail;
                    } else {
                        resultTail.next = newNode;
                        resultTail = newNode;
                    }
                }
            }
            currentNode = currentNode.next;
        }
        return resultHead;
    }
}
