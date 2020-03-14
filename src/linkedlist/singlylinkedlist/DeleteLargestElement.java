/**
 * @author Srinivas_Chintakindhi
 */

package linkedlist.singlylinkedlist;

public class DeleteLargestElement {
    public ListNode deleteLargest(ListNode head) {
        ListNode maxNode = head;
        ListNode node = head.next;

        while (node != null) {
            if (node.data > maxNode.data) {
                maxNode = node;
            }
            node = node.next;
        }

        maxNode.data = maxNode.next.data;
        maxNode.next = maxNode.next.next; // not works if last node is max node.


        return head;
    }

    public ListNode deleteLargest2(ListNode head) {
        ListNode curr = head.next;
        ListNode prev = head;

        ListNode prevToMax = null;
        ListNode maxNode = head;

        while (curr != null) {
            if (curr.data > maxNode.data) {
                prevToMax = prev;
                maxNode = curr;
            }
            prev = curr;
            curr = curr.next;
        }

        if (head == maxNode)
            head = head.next;
        else
            prevToMax.next = maxNode.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();
        ListNode listNode = new DeleteLargestElement().deleteLargest2(head);
        new PrintLinkedList().print(listNode);
    }
}
