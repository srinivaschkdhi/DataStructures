

package linkedlist.singlylinkedlist;

public class SortedList {
    public ListNode sortedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;

        ListNode leftSide = sortedList(head);
        ListNode rightSide = sortedList(slow);

        return merge(leftSide, rightSide);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode sortedTemp = new ListNode(0);
        ListNode currNode = sortedTemp;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                currNode.next = l1;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }

        if(l1!=null){
            currNode.next = l1;
            l1 = l1.next;
        }

        if(l2!=null){
            currNode.next = l2;
            l2 = l2.next;
        }

        return sortedTemp.next;
    }
}
