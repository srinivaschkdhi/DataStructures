package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SiblingsInBT {
    public boolean isSibings(Node root, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

           if(node.left != null && node.right != null){
               if ((node.left.key == x && node.right.key == y) || (node.left.key == y && node.right.key == x))
                   return true;
           }

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        boolean sibings = new SiblingsInBT().isSibings(root, 1, 4);
        System.out.println("sibings = " + sibings);
    }
}
