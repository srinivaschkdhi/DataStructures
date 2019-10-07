package linkedlist.singlylinkedlist;

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
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

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        head = reverseLinkedList.reverse(head);

        new PrintLinkedList().print(head);
    }
}
