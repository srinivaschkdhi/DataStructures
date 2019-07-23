package trees;

import java.util.*;

public class VerticalOrderPathBinaryTree {
    private static TreeMap<Integer, ArrayList> ht = new TreeMap<>();
    private static ArrayList<Integer> al;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        verticalOrderPath(root,0);
        printResult(ht);

        System.out.println("Recursion");
        ht.clear();
        al.clear();


        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        System.out.println("Iterative");
        verticalOrderPathIterative(root1, 0);
        printResult(ht);


    }

    private static void verticalOrderPath(Node root, int level) {
        if (root == null) {
            return;
        }
        if (ht.containsKey(level)) {
            ArrayList x = ht.get(level);
            x.add(root.key);
            ht.put(level, x);
        } else {
            al = new ArrayList<>();
            al.add(root.key);
            ht.put(level, al);
        }
        verticalOrderPath(root.left, level - 1);
        verticalOrderPath(root.right, level + 1);

    }

    public static void printResult(TreeMap ht) {
        Set<Integer> i = ht.keySet();
        for (int key : i) {
            System.out.println(ht.get(key));
        }
    }

    private static void verticalOrderPathIterative(Node root, int level) {
        if (root == null) {
            return;
        }

        Queue<RootLevel> queue = new LinkedList<>();
        queue.add(new RootLevel(root,0));

        while (!queue.isEmpty()) {

            RootLevel rootWithLevel = queue.poll();

            Node node = rootWithLevel.node;

            int lvl = rootWithLevel.level;

            if (ht.containsKey(lvl)) {
                ArrayList x = ht.get(lvl);
                x.add(node.key);
                ht.put(lvl, x);
            } else {
                al = new ArrayList<>();
                al.add(node.key);
                ht.put(lvl, al);
            }

            if (node.left != null) {
                queue.add(new RootLevel(node.left,lvl-1));
            }
            if (node.right != null) {
                queue.add(new RootLevel(node.right,lvl+1));
            }
        }


    }

}

class RootLevel {
    Node node;
    int level;

    public RootLevel(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}
