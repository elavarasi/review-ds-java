/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.LinkedList;

import com.review.DataStructureAlgorithm.interviewbit.chapter5_linkedlist.ListNode;

public class SumList {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(7);


        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);


        ListNode sum = addTwoNumbers(l1, l2);
        System.out.println(sum);

        while(sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addList(l1, l2, 0);
    }

    public static ListNode addList(ListNode l1, ListNode l2, int carryOn) {
        if (l1 == null && l2 == null && carryOn == 0) {
            return null;
        }

        ListNode result = new ListNode();

        int value = carryOn;

        if (l1 != null ) {
            value += l1.val;
        }

        if (l2 != null) {
            value += l2.val;
        }

        result.val = value % 10; /* second digit of number */

        /* recursively build the next set of nodes */
        if (l1 != null || l2 != null) {
            ListNode next = addList(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
            result.next = next;
        }
        return result;
    }
}
