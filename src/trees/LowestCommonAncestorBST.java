package trees;

public class LowestCommonAncestorBST {
    public static void main(String[] args) {

        Node rootNode = new Node(20);
        rootNode.left = new Node(8);
        rootNode.right = new Node(22);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(12);
        rootNode.left.right.left = new Node(10);
        rootNode.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = LCA(rootNode, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);

        n1 = 14;
        n2 = 8;
        t = LCA(rootNode, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);

        n1 = 10;
        n2 = 22;
        t = LCA(rootNode, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);

    }

    private static Node LCA(Node root, int n1, int n2){

        if (root == null) {
            return null;
        }

        if(root.key > n1 && root.key > n2){
            return LCA(root.left,n1,n2);
        }

        if(root.key < n1 && root.key < n2)
            return LCA(root.right,n1,n2);

        return root;
    }

    private static Node LCAIterative(Node root,int n1,int n2){
       while(root!=null){
           if(root.key > n1 && root.key > n2)
               root = root.left;
           else if(root.key < n1 && root.key < n2)
               root = root.right;
           else
               break;
       }
       return root;

    }
}
