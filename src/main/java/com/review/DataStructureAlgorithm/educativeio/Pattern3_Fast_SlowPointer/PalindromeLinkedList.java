package com.review.DataStructureAlgorithm.educativeio.Pattern3_Fast_SlowPointer;
/** Palindrome LinkedList (medium) #
 Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
 *
 */


class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        // First go the middle of the linked list using 2 pointers
        ListNode slowPointer  = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // Now Reverse the links from the slowPointer to the end
        ListNode newHeadPointerOfReversed = reverse(slowPointer);

        // Copy head of reversed to revert back later
        ListNode copyofReversed = newHeadPointerOfReversed;

        //Compare the first and Second Half
        while(head!= null && newHeadPointerOfReversed != null) {
            if(head.value != newHeadPointerOfReversed.value) {
                break;
            }
            head = head.next;
            newHeadPointerOfReversed = newHeadPointerOfReversed.next;
        }

        //Revert the second half
        reverse(copyofReversed);

        //If both halves are same
        if( head==null || newHeadPointerOfReversed == null) {
            return true;
        }

        return false;
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
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
