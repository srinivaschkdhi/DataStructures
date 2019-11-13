
package trees;

import java.util.LinkedList;
import java.util.Queue;


public class CheckCompleteNessBT {
    public boolean isCompleteTree(Node root) {
        boolean nullFound = false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            root = queue.poll();

            if (root == null) {
                nullFound = true;
            } else {
                if (nullFound == true) {
                    return false;
                }
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }

        return true;
    }
}
