package linkedlist.singlylinkedlist;

public class SearchElement {
    public boolean contains(ListNode head, int data) {
        ListNode current = head;

        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();

        SearchElement searchElement = new SearchElement();
        boolean contains = searchElement.contains(head, 31);
        System.out.println("contains = " + contains);
    }
}
