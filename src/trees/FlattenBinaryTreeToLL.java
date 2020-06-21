package trees;

import java.util.Stack;

public class FlattenBinaryTreeToLL {

    public static void flatten(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node current_node = stack.pop();

            if (current_node.right != null) stack.push(current_node.right);

            if (current_node.left != null) stack.push(current_node.left);

            if (!stack.isEmpty()) current_node.right = stack.peek();// the node which is going to be cuur node in next iter.
            // so cunode.right = this node.
            current_node.left = null;
        }

        print(root);
    }

    public  static void print(Node root){
        Node current = root;
        while(current != null){
            System.out.println(current.key);
            current = current.right;
        }

    }

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(5);
        flatten(rootNode);
    }
}
