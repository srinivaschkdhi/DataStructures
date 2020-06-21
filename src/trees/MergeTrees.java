package trees;

import java.util.LinkedList;
import java.util.Queue;

class MergeTrees {
    public Node mergeTrees(Node t1, Node t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.key = t1.key + t2.key;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    private Node mergeTrees2(Node t1, Node t2) {
        Queue<Node> q1 = new LinkedList<>();
        q1.add(t1);

        Queue<Node> q2 = new LinkedList<>();
        q2.add(t2);

        Node root = t1;

        while (!q1.isEmpty() || !q2.isEmpty()) {

            t1 = q1.poll();
            t2 = q2.poll();

            int x = (t1 == null) ? t1.key : 0;
            int y = (t2 == null) ? t2.key : 0;

            t1.key = x + y;

            if (t1.left != null && t2.left != null) {
                q1.add(t1.left);
                q2.add(t2.left);
            }

            if (t1.right != null && t2.right != null) {
                q1.add(t1.right);
                q2.add(t2.right);
            }
        }

        return root;
    }
}