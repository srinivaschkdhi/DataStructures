/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package trees;

import java.util.LinkedList;
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
        }

        public static void rightView(Node root){
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            int numOfNodesInCurrLvl = 1;
            int numOfNodesInNxtLvl = 0;
            q.add(root);
            while(!q.isEmpty()){

                int i = 0;
                int size = numOfNodesInCurrLvl;


                while(numOfNodesInCurrLvl > 0){
                    root = q.poll();
                    i++;

                    if(i == size)
                    System.out.print(root.key+" ");

                    if(root.left!=null){
                        numOfNodesInNxtLvl++;
                        q.add(root.left);
                    }
                    if(root.right!=null){
                        numOfNodesInNxtLvl++;
                        q.add(root.right);
                    }
                    numOfNodesInCurrLvl--;
                }


                numOfNodesInCurrLvl = numOfNodesInNxtLvl;
                numOfNodesInNxtLvl = 0;
            }
        }
}
