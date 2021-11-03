package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.LinkedList;
/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list. FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
    public static void main(String args[]) {
        Node root = new Node(5);
        root.next = new Node(6);
        root.next.next = new Node(8);
        root.next.next.next = new Node(6);
//        root.printAllNodeData(root);
//        removeListDuplicates(root);
//        root.printAllNodeData(root);

        root.printAllNodeData(root);
        removeDuplicatesNoExtraSpace(root);
        root.printAllNodeData(root);
    }


    // This solution is O(N) time complexity and has a buffer to help find duplicates
    public static void removeListDuplicates(Node root) {
        Map map = new HashMap();

        Node previousNodeProcessed = null;
        Node currentNodeProcessed = root;
        while (currentNodeProcessed != null) {
            if (map.containsKey(currentNodeProcessed.data)) {
                // Remove the duplicate node
                currentNodeProcessed = currentNodeProcessed.next;
                previousNodeProcessed.next = currentNodeProcessed;
                continue;
            } else {
                map.put(currentNodeProcessed.data, 1);

            }
            previousNodeProcessed = currentNodeProcessed;
            currentNodeProcessed = currentNodeProcessed.next;
        }
    }


    //This approach has not extra buffer / space but time complexity is O(N2)
    public static void removeDuplicatesNoExtraSpace(Node root) {
        Node current = root;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
