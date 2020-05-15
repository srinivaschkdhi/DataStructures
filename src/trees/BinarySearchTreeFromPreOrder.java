/**
 * @author Srinivas_Chintakindhi
 */

package trees;

public class BinarySearchTreeFromPreOrder {
    public Node bstFromPreoder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        Node root = new Node(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            addToBST(root, preorder[i]);
        }

        return root;
    }

    public Node addToBST(Node root, int x) {
        if (root == null)
            return new Node(x);

        if (x < root.key)
            root.left = addToBST(root.left, x);
        else
            root.right = addToBST(root.right, x);

        return root;
    }

    public static Node addToBST2(Node root, int data) {
        Node newNode = new Node(data);

        if (root == null) {
            return newNode;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (data <= current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (data <= parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;

        return root;
    }

}
