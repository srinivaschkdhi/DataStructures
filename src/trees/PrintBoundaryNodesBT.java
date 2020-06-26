package trees;

public class PrintBoundaryNodesBT {
    public void printBoundary(Node node) {
        if (node != null) {
            System.out.println(node.key + " ");

            printBoundaryLeft(node.left);

            printLeaves(node.left);
            printLeaves(node.right);

            printBoundaryRight(node.right);
        }
    }

    private void printBoundaryLeft(Node node) {
        if (node == null)
            return;

        if (node.left != null) {
            System.out.println(node.key + " ");
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            System.out.println(node.key + " ");
            printBoundaryLeft(node.right);
        }
    }

    private void printLeaves(Node node) {
        if (node == null) {
            return;
        }

        printLeaves(node.left);

        if (node.left == null && node.right == null) {
            System.out.println(node.key + " ");
        }

        printLeaves(node.right);
    }

    private void printBoundaryRight(Node node) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            printBoundaryRight(node.right);
            System.out.println(node.key + " ");
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.println(node.key + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(11);
        root.right.right = new Node(9);
        root.right.right.left = new Node(4);

        new PrintBoundaryNodesBT().printBoundary(root);
    }
}
