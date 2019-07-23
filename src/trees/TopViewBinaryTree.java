package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBinaryTree {

    private static TreeMap<Integer, Integer> ht = new TreeMap<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        topView(root,0);
    }

    private static void topView(Node root, int level) {
        if (root == null) {
            return;
        }

        Queue<RootLevel> queue = new LinkedList<>();
        queue.add(new RootLevel(root, 0));

        while (!queue.isEmpty()) {

            RootLevel rootLevel = queue.poll();
            Node node = rootLevel.root;
            int lvl = rootLevel.level;

            if (ht.containsKey(lvl)) {

            } else {
                System.out.println(node.key);
                ht.put(lvl, node.key);
            }

            if (node.left != null) queue.add(new RootLevel(node.left, lvl - 1));


            if (node.right != null) queue.add(new RootLevel(node.right, lvl + 1));
        }
    }

    static class RootLevel {
        Node root;
        int level;

        public RootLevel(Node root, int level) {
            this.root = root;
            this.level = level;
        }
    }
}

