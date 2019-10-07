package linkedlist.singlylinkedlist;

public class AddNodeAfterGivenNode {
    public ListNode addAfter(ListNode head,ListNode previous,int data){
        ListNode newNode = new ListNode(data);

        newNode.next = previous.next;
        previous.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fifth = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = fifth;

        ListNode head = first;

        AddNodeAfterGivenNode addNodeAfterGivenNode = new AddNodeAfterGivenNode();
        head = addNodeAfterGivenNode.addAfter(head, third, 4);

        new PrintLinkedList().print(head);

    }
}
