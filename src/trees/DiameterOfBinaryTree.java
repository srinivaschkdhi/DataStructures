package trees;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(Node root) {
        if (root == null)
            return 0;

        int leftHt = heightOfBT(root.left);
        int rightHt = heightOfBT(root.right);
        int leftDmtrOfBinaryTree = diameterOfBinaryTree(root.left);
        int rightDmtrOfBinaryTree = diameterOfBinaryTree(root.right);

        int fd = Math.max(leftHt + rightHt + 1, // if considers edges  remove 1 // left + rightHt only
                                                Math.max(leftDmtrOfBinaryTree, rightDmtrOfBinaryTree)
                            );

        return fd;
    }

    public int heightOfBT(Node root) {
        if (root == null)
            return 0;

        int leftHt = heightOfBT(root.left);
        int rightHt = heightOfBT(root.right);

        return 1 + Math.max(leftHt, rightHt);
    }
}