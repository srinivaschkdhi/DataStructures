package linkedlist.singlylinkedlist;

public class DeleteNodeAtPosition {

    public ListNode removeAt(ListNode head, int position) {
        ListNode previous = head;
        int currPos = 1;

        while (currPos < position - 1) {
            previous = previous.next;
            currPos++;
        }

        ListNode current = previous.next;
        previous.next = current.next;
        current.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();

        DeleteNodeAtPosition deleteNodeAtPosition = new DeleteNodeAtPosition();
        head = deleteNodeAtPosition.removeAt(head,2);

        new PrintLinkedList().print(head);

    }
}
