package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumDiffOddLvlAndEvenLvl {

    public int getLevelDiff(Node root) {
        if (root == null) {
            return 0;
        }

        int leftTreeDiff = getLevelDiff(root.left);
        int rightTreeDiff = getLevelDiff(root.right);

        return root.key - leftTreeDiff - rightTreeDiff;
    }

    public int getLevelDiff2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int evenLvlSum = 0;
        int oddLvlSum = 0;
        int numOfNodesInCurrLvl = queue.size();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (level % 2 == 0) {
                evenLvlSum += node.key;
            } else {
                oddLvlSum += node.key;
            }
            numOfNodesInCurrLvl -= 1;
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

            if (numOfNodesInCurrLvl == 0) {
                level += 1;
                numOfNodesInCurrLvl = queue.size();
            }
        }
        return evenLvlSum - oddLvlSum;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.right = new Node(9);
        root.right.right.left = new Node(4);

        root.left.right.left = new Node(5);
        root.left.right.right = new Node(11);

        int levelDiff = new SumDiffOddLvlAndEvenLvl().getLevelDiff(root);
        System.out.println("levelDiff = " + levelDiff);
        int levelDiff2 = new SumDiffOddLvlAndEvenLvl().getLevelDiff2(root);
        System.out.println("levelDiff2 = " + levelDiff2);
    }
}
