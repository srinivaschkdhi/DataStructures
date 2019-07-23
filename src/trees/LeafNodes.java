package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeafNodes {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(4);
        //rootNode.left.right = new Node(5);
        System.out.println(countNumLeafNodes(rootNode));

    }

    public static int countNumLeafNodes(Node root){
        if (root == null) {
            return 0;
        }

        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            root =  queue.poll();
            if(root.left==null && root.right==null)
                count++;

            if(root.left!=null)
                queue.add(root.left);

            if(root.right!=null)
                queue.add(root.right);;
        }
        return count;
    }

    private static int getLeafCountRecursive(Node root){
        if (root == null) {
            return 0;
        }

        if(root.left == null && root.right == null)
            return 1;
        else
            return getLeafCountRecursive(root.left)+getLeafCountRecursive(root.right);
    }
}
