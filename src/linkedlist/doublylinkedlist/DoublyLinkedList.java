package linkedlist.doublylinkedlist;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    public ListNode createDoublyLinkedList() {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        ListNode fourthNode = new ListNode(4);


        firstNode.next = secondNode;
        secondNode.previous = firstNode;

        secondNode.next = thirdNode;
        thirdNode.previous = secondNode;

        thirdNode.next = fourthNode;
        fourthNode.previous = thirdNode;

         head = firstNode;
         tail = fourthNode;

         length = 4;

        return null;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int length(){
        return length;
    }

    public void printForward(){
        ListNode current = head;

        while(current!=null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printBackWards(){
        ListNode current = tail;

        while(current!=null){
            System.out.print(current.data+"-->");
            current = current.previous;
        }
        System.out.println("null");
    }

    public void addFirst(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void addLast(int data){
        ListNode newNode = new ListNode(data);

        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        length++;
    }
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.createDoublyLinkedList();


        doublyLinkedList.printForward();
        doublyLinkedList.printBackWards();

        doublyLinkedList.addFirst(10);
        doublyLinkedList.printForward();

        doublyLinkedList.addLast(100);
        doublyLinkedList.printForward();

        System.out.println("Length of Linked List "+doublyLinkedList.length());

    }
}
