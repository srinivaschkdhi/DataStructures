package trees;

public class LowestCommonAncestorInBinaryTree {

    public static Node  lca(Node root,Node n1,Node n2){
        if (root == null) {
            return null;
        }

        if(root == n1 || root == n2)
            return root;

        Node left = lca(root.left,n1,n2);
        Node  right = lca(root.right,n1,n2);

        if(left!=null && right!=null)
            return root;

        return left!=null ? left:right;
    }

    public static void main(String[] args) {


        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(5);
        Node lca = lca(rootNode, rootNode.left, rootNode.right);
        System.out.println("lca.key = " + lca.key);
    }
}
