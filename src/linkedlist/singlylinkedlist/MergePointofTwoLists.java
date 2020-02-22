/**
 * @author Srinivas_Chintakindhi
 */

package linkedlist.singlylinkedlist;

public class MergePointofTwoLists {
    public ListNode findMergePoint(ListNode head1, ListNode head2) {
        int len1 = 0;
        ListNode curr1 = head1;
        while (curr1 != null) {
            len1++;
            curr1 = curr1.next;
        }

        int len2 = 0;
        ListNode curr2 = head2;
        while (curr2 != null) {
            len2++;
            curr2 = curr2.next;
        }

        if (curr1 != curr2)
            return null;

        int diff = len2 - len1;//assuming second list is big

        if (len1 > len2) {// if first list is big swap first into second so that it fits into logic.
            ListNode temp = head1;
            head1 = head2;
            head2 = temp;
            diff = len1 - len2;
        }

        for (int i = 0; i < diff; i++) {
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2)
                return head1;

            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }
}
