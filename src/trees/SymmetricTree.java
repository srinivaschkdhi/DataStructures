
package trees;

class SymmetricTree {
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
}
