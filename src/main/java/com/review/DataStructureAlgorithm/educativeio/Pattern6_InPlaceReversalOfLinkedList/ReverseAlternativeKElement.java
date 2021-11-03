package com.review.DataStructureAlgorithm.educativeio.Pattern6_InPlaceReversalOfLinkedList;
/*
Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */


class ReverseAlternativeKElement {
    public static ListNode reverse(ListNode head, int k) {

        // If head is null or K is 1 then return head
        if (head == null || k <= 1) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        // reverse alternative k nodes
        while (true) {
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSubList = current;

            ListNode next;
            // Reverse K nodes
            for (int i = 0; current != null && i < k; i++ ) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // Update lastNodeOfPreviousPart
            if(lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous; // previous is now the first node of the sub-list
            } else {
                head = previous; // we are changing the head of the linked list.
            }

            // Connect to the next part
            lastNodeOfSubList.next = current;

            // Skip the next alternative k nodes
            for (int i = 0; current != null && i < k; i++) {
                previous = current;
                current = current.next;
            }

            // If we have reached the end break.
            if (current == null) {
                break;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseAlternativeKElement.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}