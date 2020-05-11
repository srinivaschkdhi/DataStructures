/**
 * @author Srinivas_Chintakindhi
 */

package linkedlist.singlylinkedlist;

public class RotateLeftLinkedList {
    public ListNode leftRotate(ListNode head, int k) {
        ListNode kthNode = head;
        ListNode kOneMinusNode = kthNode;

        int pos = 0;
        while (pos < k) {
            kOneMinusNode = kthNode;
            kthNode = kthNode.next;
            pos += 1;
        }

        kOneMinusNode.next = null; // pointing k-1 node next to null to make end of list

        ListNode curr = kthNode;
        while (curr.next != null)
            curr = curr.next;
        curr.next = head; // pointing last node next to head

        return kthNode; // making kth node as head to make begin of list
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();
        new PrintLinkedList().print(head);
        ListNode leftRotatedHead = new RotateLeftLinkedList().leftRotate(head, 3);
        new PrintLinkedList().print(leftRotatedHead);
    }
}
// 3. Make last node point to head
// 1 . Make kth node as head
// 2. Make k -1 th node as tail