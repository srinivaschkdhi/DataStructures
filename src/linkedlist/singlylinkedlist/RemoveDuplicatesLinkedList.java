package linkedlist.singlylinkedlist;

public class RemoveDuplicatesLinkedList {
    public ListNode removeDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else
                current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();

        RemoveDuplicatesLinkedList removeDuplicatesLinkedList = new RemoveDuplicatesLinkedList();
         head = removeDuplicatesLinkedList.removeDuplicates(head);

         new PrintLinkedList().print(head);
    }
}
