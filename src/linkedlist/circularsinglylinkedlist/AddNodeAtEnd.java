package linkedlist.circularsinglylinkedlist;

public class AddNodeAtEnd {
    public ListNode addLast(ListNode last, int data) {
        ListNode newNode = new ListNode(data);
        if (last == null) {
            last = newNode;
            last.next = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }

        return last;
    }

    public static void main(String[] args) {
        ListNode last = new CreateCircularSinglyLinkedList().invoke();

        AddNodeAtEnd addNodeAtEnd = new AddNodeAtEnd();
        last = addNodeAtEnd.addLast(last,100);

        new PrintCircularSinglyLinkedList().print(last);
    }
}
