
package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(Node root) {
        return isMirror(root, root);
    }

    private boolean isMirror(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        return (t1.key == t2.key) && isMirror(t1.left, t2.right) && isMirror(t2.left, t1.right);
    }

    private boolean isMirror2(Node t1, Node t2) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(t1);
        q2.add(t2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node n1 = q1.poll();
            Node n2 = q2.poll();

            if (n1.key != n2.key)
                return false;


            if (n1.left != null && n2.right != null) {
                q1.add(n1.left);
                q2.add(n2.right);
            } else if ((n1.left != null && n2.right == null) || (n1.left == null && n2.right != null))
                return false;

            if (n1.right != null && n2.left != null) {
                q1.add(n1.right);
                q2.add(n2.left);
            } else if ((n1.right != null && n2.left == null) || (n1.right == null && n2.left != null))
                return false;
        }

        return true;
    }
}
