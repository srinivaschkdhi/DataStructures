package linkedlist.singlylinkedlist;

public class AddNodeAtBeginning {

    public ListNode addFirst(ListNode head, int data) {
        ListNode newNode = new ListNode(data);

        newNode.next = head;
        head = newNode;

        return head;
    }

    public static void main(String[] args) {
       ListNode head = new CreateLinkedList().invoke();
        AddNodeAtBeginning addNodeAtBeginning = new AddNodeAtBeginning();
        head = addNodeAtBeginning.addFirst(head, 1);
        new PrintLinkedList().print(head);
    }
}
