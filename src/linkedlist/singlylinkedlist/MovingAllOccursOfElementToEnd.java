package linkedlist.singlylinkedlist;

import java.lang.management.MonitorInfo;

public class MovingAllOccursOfElementToEnd {
    public ListNode moveToEnd(ListNode head, int val) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode temp = null;
        ListNode next = null;
        ListNode tail = null;
        ListNode prev = null;

        // find tail of linked list
        while (curr.next != null)
            curr = curr.next;

        tail = curr;
        ListNode unModifiedTail = tail;

        curr = head;

        while (curr != unModifiedTail) {
            if (curr.data == val && prev == null) {
                next = curr.next;

                curr.next = null;

                tail.next = curr;
                tail = tail.next;

                curr = head = next;

            } else if (curr.data == val && prev != null) {
                next = curr.next;

                prev.next = curr.next;
                curr.next = null;

                tail.next = curr;
                tail = tail.next;

                curr = next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        MovingAllOccursOfElementToEnd movingAllOccursOfElementToEnd = new MovingAllOccursOfElementToEnd();

        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(0);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        ListNode head = first;

        head = movingAllOccursOfElementToEnd.moveToEnd(head,0);

        new PrintLinkedList().print(head);
    }
}
/*
Taking reference of next node
delete the node
add deleted node to end tail of linkedlist
updating curr node
 */