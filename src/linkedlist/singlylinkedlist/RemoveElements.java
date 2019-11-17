

package linkedlist.singlylinkedlist;


public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.data == val) {
            head = head.next;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.data == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}
