/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO: Javadoc
 */
public final class RightViewBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        rightView(root);
        rightView2(root);
    }

    public static void rightView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        int numOfNodesInCurrLvl = 1;
        int numOfNodesInNxtLvl = 0;
        q.add(root);
        while (!q.isEmpty()) {

            int i = 0;
            int size = numOfNodesInCurrLvl;


            while (numOfNodesInCurrLvl > 0) {
                root = q.poll();
                i++;

                if (i == size)
                    System.out.print(root.key + " ");

                if (root.left != null) {
                    numOfNodesInNxtLvl++;
                    q.add(root.left);
                }
                if (root.right != null) {
                    numOfNodesInNxtLvl++;
                    q.add(root.right);
                }
                numOfNodesInCurrLvl--;
            }


            numOfNodesInCurrLvl = numOfNodesInNxtLvl;
            numOfNodesInNxtLvl = 0;
        }
    }

    public static void rightView2(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int numOfNodesInCurLvl = queue.size();
            int lastPosInThisCurLvl = queue.size();

            int nodePosInLvl = 0;

            while (numOfNodesInCurLvl > 0) {

                nodePosInLvl += 1;
                root = queue.poll();

                if (nodePosInLvl == lastPosInThisCurLvl)
                    System.out.println(root.key + " ");

                if (root.left != null)
                    queue.add(root.left);

                if (root.right != null)
                    queue.add(root.right);

                numOfNodesInCurLvl--;
            }

        }

    }

    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;


        Queue<Node> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            int numNodesInCurrLvl = queue.size();
            int nodePosInLvl = 0;


            while (numNodesInCurrLvl > 0) {

                nodePosInLvl += 1;
                root = queue.poll();

                if (nodePosInLvl == 1)
                    result.add(root.key);


                if (root.right != null) {
                    queue.add(root.right);
                }

                if (root.left != null) {
                    queue.add(root.left);
                }


                numNodesInCurrLvl -= 1;
            }

        }

        return result;
    }
    
    public void rightVieww(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int noOfNodesInCurrLvl = queue.size();
        int pos = 0;
        int lastIndex = queue.size();

        while (!queue.isEmpty()) {
            root = queue.poll();
            pos += 1;

            if(pos == lastIndex)
                System.out.println(root);

            if(root.left != null)
                queue.add(root.left);

            if(root.right != null)
                queue.add(root.right);

            noOfNodesInCurrLvl--;
            
            if(noOfNodesInCurrLvl == 0){
                pos = 0;
                noOfNodesInCurrLvl  = queue.size();
                lastIndex = queue.size();
            }
        }
    }
}
