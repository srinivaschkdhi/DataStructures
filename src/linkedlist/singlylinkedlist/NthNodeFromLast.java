package linkedlist.singlylinkedlist;

public class NthNodeFromLast {
    public ListNode nthNodeFromLast(ListNode head, int n) {
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;

        while (count < n) {
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        return mainPtr;
    }

    public static void main(String[] args) {
        ListNode head = new CreateLinkedList().invoke();

        NthNodeFromLast nF = new NthNodeFromLast();
        ListNode nthNodeFrmLast = nF.nthNodeFromLast(head,2);
        System.out.println("nthNodeFrmLast = " + nthNodeFrmLast.data);
    }
}
