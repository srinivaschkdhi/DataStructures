package linkedlist.singlylinkedlist;

public class CreateLinkedList {

    public ListNode invoke() {
        ListNode firstNode = new ListNode(1000);
        ListNode secondNode = new ListNode(21000);
        ListNode thirdNode = new ListNode(21);
        ListNode fourthNode = new ListNode(400);

        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        return firstNode;
    }
}