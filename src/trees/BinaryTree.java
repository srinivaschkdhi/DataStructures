package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {


        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(5);

        System.out.println("PREORDER TRAVERSALS");

        preOrderTraversal(rootNode);
        System.out.println();
        preOrderIterative(rootNode);
        System.out.println();

        System.out.println("POSTORDER TRAVERSALS");

        System.out.println();
        postOrderTravseral(rootNode);
        System.out.println();
        postOrderTraversalIterative(rootNode);

        System.out.println();
        System.out.println("INORDER TRAVERSALS");

        System.out.println();
        inOrderTraversal(rootNode);

        System.out.println();
        System.out.println("LEVELORDER TRAVERSALS");
        levelOrder(rootNode);
        System.out.println();
        levelOrderGeeks(rootNode);


    }

    static void preOrderTraversal(Node root) {
        if (root == null) return;

        System.out.print(root.key);

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);

    }

    static void preOrderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.key);
            if (root.right != null) stack.add(root.right);
            if (root.left != null) stack.add(root.left);
        }
    }

    static void postOrderTravseral(Node root) {
        if (root == null) return;
        postOrderTravseral(root.left);
        postOrderTravseral(root.right);
        System.out.print(root.key);
    }


    static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.key);
        inOrderTraversal(root.right);
    }

    static void levelOrder(Node root) {
        Node tempNode = root;
        Queue<Node> queue = new LinkedList<>();
        while (tempNode != null) {

            System.out.print(tempNode.key);

            if (tempNode.left != null) queue.add(tempNode.left);

            if (tempNode.right != null) queue.add(tempNode.right);

            tempNode = queue.poll();

        }
    }

    static void levelOrderGeeks(Node root) {

        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.key);

            if (tempNode.left != null) queue.add(tempNode.left);

            if (tempNode.right != null) queue.add(tempNode.right);

        }
    }

    static void postOrderTraversalIterative(Node root){
        if (root == null) {
            return;
        }

        Stack<Node> stackOne = new Stack<>();
        Stack<Node> stackTwo = new Stack<>();

        stackOne.add(root);
        while(!stackOne.isEmpty()){
            root = stackOne.pop();
            stackTwo.add(root);

            if(root.left!=null)
                stackOne.add(root.left);

            if(root.right!=null)
                stackOne.add(root.right);
        }

        while(!stackTwo.isEmpty()){
            root = stackTwo.pop();
            System.out.print(root.key);
        }

    }



}

class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

}