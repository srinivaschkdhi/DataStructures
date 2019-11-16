package linkedlist.singlylinkedlist;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (m > 1) { // when to you reach to m , m is tail of reversed list and m-1 is left node to
            prev = curr;// be connected to head of reversed list
            curr = curr.next;
            m -= 1;
            n -= 1;
        }

        ListNode leftConNode = prev;
        ListNode tailOfReverseList = curr;

        ListNode next = curr;
        prev = null;

        while (n > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n -= 1;
        }

        ListNode headOfReversedList = prev;

        if (leftConNode != null) {
            leftConNode.next = headOfReversedList;
        } else {
            head = headOfReversedList;
        }

        tailOfReverseList.next = curr;
        return head;
    }

}
