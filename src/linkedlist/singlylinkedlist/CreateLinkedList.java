package linkedlist.singlylinkedlist;

public class CreateLinkedList {

    public ListNode invoke() {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode fourthNode = new ListNode(4);

        firstNode.next = secondNode;
        secondNode.next = fourthNode;

        return firstNode;
    }
}