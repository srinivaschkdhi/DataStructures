package trees;

public class InsertNodeBST {
    public static void main(String[] args) {
        Node rootNode = new Node(50);
        rootNode.left = new Node(20);
        rootNode.right = new Node(30);
        rootNode.left.left = new Node(10);
        rootNode.left.right = new Node(15);
        insert(rootNode, 40);
    }

    public static Node insert(Node root, int data) {
        Node newNode = new Node(data);

        if (root == null) {
            return newNode;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (data <= current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (data <= parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;

        return root;
    }
}
