package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftMost {
    public static int findBottomLeftValue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();

            if (root.right != null) {
                queue.add(root.right);
            }

            if (root.left != null) {
                queue.add(root.left);
            }
        }

        return root.key;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        root.right.left = new Node(5);
        root.right.right = new Node(6);

        root.right.left.left = new Node(7);

        System.out.println(findBottomLeftValue(root));
    }
}
