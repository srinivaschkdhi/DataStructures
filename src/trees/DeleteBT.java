package trees;

public class DeleteBT {
    public Node deleteBinaryTree(Node node) {
        if (node == null)
            return null;

        node.left = deleteBinaryTree(node.left);
        node.right = deleteBinaryTree(node.right);

        System.out.println("Deleting node " + node.key);
        node = null;// after returning from two childs(its two calls) delete the node
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }
}
