package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelofNode {
    public int getLevel(Node root, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int numNodesIncurLvl = queue.size();

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

            if (node.key == x)
                return level;

            numNodesIncurLvl--;
            if (numNodesIncurLvl == 0) {
                level += 1;
                numNodesIncurLvl = queue.size();
            }
        }
        return -1;
    }

    public static int getLevelOfNode(Node root, int key, int level) {
        if (root == null)
            return 0;

        if (root.key == key)
            return level;

        int result = getLevelOfNode(root.left, key, level + 1);
        if (result != 0) {
            // If found in left subtree , return
            return result;
        }
        result = getLevelOfNode(root.right, key, level + 1);

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int level = new LevelofNode().getLevel(root, 4);
        System.out.println("level = " + level);
        int levelOfNode = getLevelOfNode(root, 4, 0);
        System.out.println("levelOfNode = " + levelOfNode);
    }
}
