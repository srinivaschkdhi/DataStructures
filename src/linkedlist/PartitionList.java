public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode bfHead = new ListNode(0);
        ListNode bf = bfHead;

        ListNode aftrHead = new ListNode(0);
        ListNode aftr = aftrHead;

        while (head != null) {
            if (head.data < x) {
                bf.next = head;
                bf = bf.next;
            } else {
                aftr.next = head;
                aftr = aftr.next;
            }
            head = head.next;
        }

        aftr.next = null;
        bf.next = aftrHead.next;

        return bfHead.next;
    }
}
