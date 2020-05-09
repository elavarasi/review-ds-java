package com.review.ds.educativeio.Pattern3_Fast_SlowPointer;

/**
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
 *
 * If the total number of nodes in the LinkedList is even, return the second middle node.
 *
 * Example 1:
 *
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * Output: 3
 * Example 2:
 *
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
 * Output: 4
 * Example 3:
 *
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
 * Output: 4
 */

public class MiddleOfTheLinkedList {
    public static ListNode findMiddle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + MiddleOfTheLinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + MiddleOfTheLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + MiddleOfTheLinkedList.findMiddle(head).value);
    }

}
