package linkedlist.singlylinkedlist;

public class AddNodeAtEnd {

    public ListNode addLast(ListNode head, int data) {

        ListNode newNode = new ListNode(data);

        if (head == null)
            head = newNode;
         else {
             ListNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
        return head;
    }

    public static void main(String[] args) {

    ListNode head = new CreateLinkedList().invoke();

        AddNodeAtEnd addNodeAtEnd = new AddNodeAtEnd();

        head = addNodeAtEnd.addLast(head, 3);

        new PrintLinkedList().print(head);



    }
}
