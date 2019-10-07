package linkedlist.circularsinglylinkedlist;

public class CreateCircularSinglyLinkedList {
    public ListNode invoke() {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(8);
        ListNode thirdNode = new ListNode(10);
        ListNode fourthNode = new ListNode(16);

        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = firstNode;

        ListNode last = fourthNode;

        return last;
    }
}
