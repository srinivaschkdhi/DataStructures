
package linkedlist.singlylinkedlist;


public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
