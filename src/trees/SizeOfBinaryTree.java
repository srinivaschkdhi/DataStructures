package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(4);
        System.out.println(sizeOfBSTIterative(rootNode));
        System.out.println(sizeOfBST(rootNode));
    }


    private static int sizeOfBST(Node root) {
        if (root == null) {
            return 0;
        }
        return sizeOfBST(root.left)+sizeOfBST(root.right)+1;
    }


    private static int sizeOfBSTIterative(Node root){
            if (root == null) {
                return 0;
             }

        Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            int size  = 0;
            while(!queue.isEmpty()){
                root = queue.poll();

                size++;

                if(root.left!=null)
                    queue.add(root.left);

                if(root.right!=null)
                    queue.add(root.right);
            }


        return size;
    }
}
