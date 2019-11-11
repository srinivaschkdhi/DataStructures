/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package linkedlist.singlylinkedlist;

class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        fastPtr = head;
        slowPtr = reverse(slowPtr);

        while (slowPtr != null && fastPtr != null) {
            if (slowPtr.data != fastPtr.data) {
                return false;
            }

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();

        System.out.println(isPalindrome(head));

    }
}
