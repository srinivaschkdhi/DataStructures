package linkedlist.singlylinkedlist;

public class RemoveKeyFromLinkedList {
    public ListNode removeKey(ListNode head, int key) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }

        if (current == null) return head;
        previous.next = current.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();

        RemoveKeyFromLinkedList removeKeyFromLinkedList = new RemoveKeyFromLinkedList();
        head = removeKeyFromLinkedList.removeKey(head,2);

        new PrintLinkedList().print(head);

    }

}
