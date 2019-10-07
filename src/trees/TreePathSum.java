package trees;

public class TreePathSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(treePathSum(root,0));
    }

    private static int treePathSum(Node root,int val){

        if (root == null) {
            return 0;
        }

        val = val*10+root.key;
        if(root.left == null && root.right == null)
            return val;
        return treePathSum(root.left,val) + treePathSum(root.right,val);
    }
}
