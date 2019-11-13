
package trees;

public class PruneTree {
    public Node pruneTree(Node root) {
        if (root == null) {
            return null;
        }

        containsOne(root);
        return root;
    }

    private boolean containsOne(Node root) {
        if (root == null) {
            return false;
        }

        boolean leftContains = containsOne(root.left);
        boolean rightContains = containsOne(root.right);

        if (!leftContains) {
            root.left = null;
        }

        if (!rightContains) {
            root.right = null;
        }

        return (root.key == 1 || leftContains || rightContains);
    }
}
