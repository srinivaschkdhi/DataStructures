package linkedlist.circularsinglylinkedlist;

public class PrintCircularSinglyLinkedList {
    public void print(ListNode last){
        if(last == null)
            return;

        ListNode first = last.next;

        while(first!=last){
            System.out.print(first.data+"-->");
            first = first.next;
        }

        System.out.println(first.data);

    }
}
