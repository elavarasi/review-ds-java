package com.review.ds.educativeio.Pattern6_InPlaceReversalOfLinkedList;
/*
Problem Statement #
Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
 */

public class ReverseASubList {

    public static ListNode reverseASubList(ListNode head, int p,  int q) {
        if (p == q) {
            return head;
        }

        // Find the node to start reversal. Also store the previous node of start node
        ListNode start = head;
        ListNode startPrevious = null;
        while(start.value != p ) {
            startPrevious = start;
            start = start.next;
        }

        // Reverse from start to q
        ListNode previous = startPrevious;
        ListNode current = start;
        ListNode next = null;
        while(previous.value != q) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // Now set correct next value for reversed items
        start.next = current;
        startPrevious.next = previous;

        return head;
    }


    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        ListNode result = reverseASubList(head, 1, 4);
        while(result != null) {
            System.out.println(result.value);
            result = result.next;
        }

    }

}
