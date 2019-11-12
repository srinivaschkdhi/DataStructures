
package linkedlist.singlylinkedlist;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddHead = head;
        ListNode evenHead = oddHead.next;

        ListNode oddCur = head;
        ListNode evenCur = oddCur.next;

        while (evenCur != null && evenCur.next != null) {
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;

            evenCur.next = oddCur.next;
            evenCur = evenCur.next;
        }

        oddCur.next = evenHead;
        return oddHead;
    }
}
