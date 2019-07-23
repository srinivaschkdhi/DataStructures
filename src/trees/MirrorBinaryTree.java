/*
Do the PreOrder Traversal.
Starting from the root, swap the left and right childs.
Recursively call the same procedure in the leftsubtree and right subtree
 */

package trees;

import java.util.Stack;

public class MirrorBinaryTree {
    public static void main(String[] args) {
        Node rootNode = new Node(4);
        rootNode.left = new Node(2);
        rootNode.right = new Node(6);
        rootNode.left.left = new Node(1);
        rootNode.left.right = new Node(3);
        rootNode.right.left = new Node(5);
        rootNode.right.right = new Node(7);
        inOrderTraversal(rootNode);
        //rootNode=mirrorTree(rootNode);
        //System.out.println();
        //inOrderTraversal(rootNode);
        System.out.println();
        rootNode = mirrorTree(rootNode);
        inOrderTraversal(rootNode);
    }

    private static Node mirrorTree(Node root){
        if (root!=null) {
            // swapping left and right childs
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;


            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }

    private static void inOrderTraversal(Node root){
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while(true){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.isEmpty())
                    break;
                root = stack.pop();
                System.out.print(root.key+" ");
                root = root.right;
            }
        }
    }



    private static Node mirrorBTIterative(Node root){
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            root = stack.pop();

            if(root.left!=null){
                stack.add(root.left);
            }

            if(root.right!=null){
                stack.add(root.right);
            }

        }
       return root;

    }

}
