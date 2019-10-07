package linkedlist.singlylinkedlist;

public class DeleteNodeAtEnd {

    public ListNode removeLast(ListNode head){
        ListNode last = head;
        ListNode previousToLast = null;

        while(last.next!=null){
            previousToLast = last;
            last = last.next;
        }

        previousToLast.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();

        DeleteNodeAtEnd deleteNodeAtEnd = new DeleteNodeAtEnd();
        head = deleteNodeAtEnd.removeLast(head);

        new PrintLinkedList().print(head);
    }


}
