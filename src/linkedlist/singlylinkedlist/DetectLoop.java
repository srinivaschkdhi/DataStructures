package linkedlist.singlylinkedlist;

public class DetectLoop {
    public boolean isLoopPresent(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode fNode = new ListNode(1);
        ListNode sNode = new ListNode(2);
        ListNode tNode = new ListNode(3);
        ListNode fourthNode = new ListNode(4);
        ListNode fifNode = new ListNode(5);
        ListNode sixNode = new ListNode(6);

        fNode.next = sNode;
        sNode.next = tNode;
        tNode.next = fourthNode;
        fourthNode.next = fifNode;
        fifNode.next = sixNode;

        sixNode.next = tNode;

        ListNode head = fNode;

        DetectLoop detectLoop = new DetectLoop();
        System.out.println(detectLoop.isLoopPresent(head));

    }
}
