/**
 * @author Srinivas_Chintakindhi
 */

package linkedlist.singlylinkedlist;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.util.HashMap;
import java.util.LinkedList;

public class CloneLinkedListRandom {
    public Node clone(Node head){
        if (head == null) {
            return head;
        }

        Node curr = head;
        Node next = null;

        while(curr !=null){
            next = curr.next;

            Node newNode = new Node(curr.data);
            curr.next = newNode;
            newNode.next = next;

            curr = next;
        }

        curr = head;
        while(curr != null){
            curr.next.random = curr.random.next;

            if(curr.next!=null)
                curr = curr.next.next;
            else
                curr = curr.next;
        }

         Node node = head;
         Node copy = node.next;
         Node tempCopy = copy;

         while(node != null && copy!=null){
             if(node.next != null)
                 node.next = node.next.next;
             else
                 node.next = node.next;


             if(copy.next != null)
                 copy.next = copy.next.next;
             else
                 copy.next = copy.next;
         }

         return tempCopy;
    }

    public Node cloneUsingHashmap(Node firstHead) {
        if (firstHead == null) {
            return null;
        }

        HashMap<Node, Node> m = new HashMap<>();
        Node secondHead = null, secondNode = null;
        Node firstNode = firstHead;

        while (firstNode != null) {
            Node newNode = new Node(firstNode.data);
            if (secondHead == null) {
                secondHead = newNode;
                secondNode = secondHead;
            } else {
                secondNode.next = newNode;
                secondNode = newNode;
            }

            m.put(firstNode, secondNode);
            firstNode = firstNode.next;
        }

        firstNode = firstHead;
        secondNode = secondHead;

        while (firstNode != null) {
            if (firstNode.random != null) {
                secondNode.random = m.get(firstNode.random);
            }

            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        return secondHead;
    }

    public static void main(String[] args) {

        LinkedList a = new LinkedList();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next.next.next;
        head.next.next.next.next.random = head.next;

        // Node clone = a.clone(head);
        Node clone2 = new CloneLinkedListRandom().cloneUsingHashmap(head);
    }


}

class Node{
    Node next;
    Node random;
    int data;

    Node(int data){
        this.data = data;
        this.next = null;
        this.random = null;
    }
}