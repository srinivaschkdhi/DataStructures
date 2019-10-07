package linkedlist.singlylinkedlist;

public class PrintLinkedList {
    public void print(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println("null");
    }
}
