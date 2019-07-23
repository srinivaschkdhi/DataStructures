package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SearchElementBinaryTree {
    public static void main(String[] args) {
        Node rootNode = new Node(20);
        rootNode.left = new Node(8);
        rootNode.right = new Node(22);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(12);
        rootNode.left.right.left = new Node(10);
        rootNode.left.right.right = new Node(14);
        System.out.println(searchElementBT(rootNode,100));
        System.out.println(searchElementBTIterative(rootNode,10));
    }

    private static boolean searchElementBT(Node root,int x){

        if(root!=null){
            if(root.key == x)
                return true;
            else // check if the sub trees
                return searchElementBT(root.left,x) || searchElementBT(root.right,x);
        }
        return false;
    }

    private static boolean searchElementBTIterative(Node root,int x){
        if (root == null) {
            return false;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.key == x)
                return true;

            if(root.left!=null)
                queue.add(root.left);

            if(root.right!=null)
                queue.add(root.right);
        }
        // if reached here, means we have not found the element
        return false;
    }
}
