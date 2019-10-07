package linkedlist.singlylinkedlist;

public class DeleteNodeAtBeginning {
    public ListNode removeFirst(ListNode head){
        ListNode temp = head;

        head = head.next;
        temp.next = null;

        return head;
    }

    public static void main(String[] args) {
       ListNode head = new CreateLinkedList().invoke();

        DeleteNodeAtBeginning deleteNodeAtBeginning = new DeleteNodeAtBeginning();
        head = deleteNodeAtBeginning.removeFirst(head);

        new PrintLinkedList().print(head);

    }
}
