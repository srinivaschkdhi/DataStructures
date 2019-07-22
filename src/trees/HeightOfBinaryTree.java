package trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(4);
        System.out.println(heightOfBST(rootNode));
        System.out.println(heightOfBSTIterative(rootNode));
    }

    private static int heightOfBST(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHt = heightOfBST(root.left);
        int rightHt = heightOfBST(root.right);
        return 1 + Math.max(leftHt, rightHt);
    }


    private static int heightOfBSTIterative(Node node) {
        // Base Case
        if (node == null)
            return 0;

        // Create an empty queue for level order tarversal
        Queue<Node> q = new LinkedList();

        // Enqueue Root and initialize height
        q.add(node);
        int height = 0;

        while (1 == 1)
        {
            // nodeCount (queue size) indicates number of nodes
            // at current lelvel.
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0)
            {
                Node newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
    }
}
