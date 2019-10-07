package linkedlist.singlylinkedlist;

public class AddNodeAtPositon {
    public ListNode insertAt(ListNode head,int data,int position){
        ListNode newNode = new ListNode(data);
        ListNode previous = head;
        int currPos = 1;

        while(currPos < position -1){
            previous = previous.next;
            currPos++;
        }

        newNode.next = previous.next;
        previous.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();

        AddNodeAtPositon addNodeAtPositon = new AddNodeAtPositon();
        head = addNodeAtPositon.insertAt(head, 3, 3);
        new PrintLinkedList().print(head);


    }
}
