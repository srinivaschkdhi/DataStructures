package linkedlist.circularsinglylinkedlist;

public class AddNodeAtBeginning {
    public ListNode addFirst(ListNode last, int data) {
        ListNode newNode = new ListNode(data);
        if (last == null) {
            last = newNode;
            last.next = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode last = new CreateCircularSinglyLinkedList().invoke();

        AddNodeAtBeginning addNodeAtBeginning = new AddNodeAtBeginning();
        last = addNodeAtBeginning.addFirst(last,0);

        new PrintCircularSinglyLinkedList().print(last);
    }
}
