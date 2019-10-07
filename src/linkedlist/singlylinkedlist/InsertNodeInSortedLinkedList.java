package linkedlist.singlylinkedlist;

public class InsertNodeInSortedLinkedList {
    public ListNode insert(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        ListNode previous = null;

        while (current != null && current.data <= data) {
            previous = current;
            current = current.next;
        }

        newNode.next = current;
        previous.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();

        InsertNodeInSortedLinkedList insertNodeInSortedLinkedList = new InsertNodeInSortedLinkedList();
        head = insertNodeInSortedLinkedList.insert(head, 1);

        new PrintLinkedList().print(head);

    }
}
