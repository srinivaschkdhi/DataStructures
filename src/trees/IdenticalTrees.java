package trees;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalTrees {

    public static void main(String[] args) {
        Node rootNode1 = new Node(1);
        rootNode1.left = new Node(2);
        rootNode1.right = new Node(3);
        rootNode1.left.left = new Node(4);


        Node rootNode2 = new Node(1);
        rootNode2.left = new Node(2);
        rootNode2.right = new Node(3);
        rootNode2.left.left = new Node(4);

        boolean isIdentaical = identicalTreesRecursive(rootNode1, rootNode2);
        System.out.println("isIdentaical = " + isIdentaical);
    }

    private static boolean identicalTrees(Node rootNode1, Node rootNode2) {

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        queue1.add(rootNode1);
        queue2.add(rootNode2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            Node n1 = queue1.poll();
            Node n2 = queue2.poll();

            if (n1.key != n2.key) return false;

            if (n1.left != null && n2.right != null) {
                queue1.add(n1.left);
                queue2.add(n2.left);
            } else if ((n1.left == null && n2.left != null) || (n1.left != null && n2.left == null)) return false;


            if (n1.right != null && n2.right != null) {
                queue1.add(n1.right);
                queue2.add(n2.right);
            } else if ((n1.right == null && n2.right != null) || (n1.right != null && n2.right == null)) return false;

        }

        return true;
    }

    private static boolean identicalTreesRecursive(Node a, Node b) {
        /*1. both empty */
        if (a == null && b == null) return true;

        /* 2. both non-empty -> compare them */
        if (a != null && b != null)
            return (a.key == b.key && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));

        /* 3. one empty, one not -> false */
        return false;
    }

}
