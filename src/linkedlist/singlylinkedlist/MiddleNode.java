package linkedlist.singlylinkedlist;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();


        MiddleNode middleNode = new MiddleNode();
        ListNode midNode = middleNode.middleNode(head);

        System.out.println("midNode = " + midNode.data);
    }
}
