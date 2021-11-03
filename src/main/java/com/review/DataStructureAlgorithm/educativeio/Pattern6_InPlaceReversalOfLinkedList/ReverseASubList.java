package com.review.DataStructureAlgorithm.educativeio.Pattern6_InPlaceReversalOfLinkedList;
/*
Problem Statement #
Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
 */

public class ReverseASubList {

    public static ListNode reverseASubList(ListNode head, int p,  int q) {
        if (p == q) {
            return head;
        }

        // skip p-1 nodes, current will point to pth node
        ListNode previous = null;
        ListNode current = head;

        for (int i = 0; current != null && i<p-1; i++) {
            previous = current;
            current = current.next;
        }

        // There are 3 parts, part before 'p', part between 'p' and 'q' and part after index 'q'
        // Store the node before part p
        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSublist = current;

        ListNode next = null;
        // Reverse nodes between 'p' and 'q'
        for (int i=0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // Connect with the first part
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;
        } else { // This means p == 1 We are changing the first node (head of the linked list)
            head = previous;
        }

        // Connect with the last part
        lastNodeOfSublist.next = current;

        return head;
    }


    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        ListNode result = reverseASubList(head, 2, 4);
        while(result != null) {
            System.out.println(result.value);
            result = result.next;
        }

    }

}
