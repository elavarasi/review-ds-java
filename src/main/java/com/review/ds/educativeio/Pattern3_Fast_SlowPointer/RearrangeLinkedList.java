package com.review.ds.educativeio.Pattern3_Fast_SlowPointer;

import java.util.List;

/**
 * Rearrange a LinkedList (medium) #
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 *
 * Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
 *
 * Example 1:
 *
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
 * Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
 * Example 2:
 *
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
 * Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
 */

public class RearrangeLinkedList {
    public static void reorder(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        //Find the middle of the linked list
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        //Reverse the second half and get the head
        ListNode headOfSecondHalf = reverse(slowPointer);
        ListNode headOfFirstHalf = head;

        //Iterate both half and shuffle the linked list
        while(headOfFirstHalf != null && headOfSecondHalf !=null) {
            ListNode tmp = headOfFirstHalf.next;
            headOfFirstHalf.next = headOfSecondHalf;
            headOfFirstHalf = tmp;

            tmp = headOfSecondHalf.next;
            headOfSecondHalf.next = headOfFirstHalf;
            headOfSecondHalf = tmp;
        }

        //Set last node to null
        if(headOfFirstHalf != null) {
            headOfFirstHalf.next = null;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeLinkedList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}


