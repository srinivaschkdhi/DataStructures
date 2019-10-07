package linkedlist.singlylinkedlist;

public class LinkedListLength {
    public int length(ListNode head){
        ListNode current = head;
        int count = 0; 
        
        while(current!=null){
            count++;
            current = current.next;
        }
        
        return count;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();
        
        LinkedListLength linkedListLength = new LinkedListLength();
        int length = linkedListLength.length(head);
        System.out.println("length = " + length);
    }
}
