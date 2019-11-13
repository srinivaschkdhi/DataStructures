
package trees;


public  class UniValTree {
    public boolean isUnivalTree(Node root) {
        boolean leftUniVal = root.left == null || (root.left.key == root.key && isUnivalTree(root.left));

        boolean rightUnival = root.right == null || (root.right.key == root.key && isUnivalTree(root.right));

        return leftUniVal && rightUnival;
    }
}
