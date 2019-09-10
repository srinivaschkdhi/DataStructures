package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversalLevelByLevel {
    public static void levelByLevelTwoQueue(Node root){
        if (root == null) {
            return;
        }

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root);

        while(!q1.isEmpty()||!q2.isEmpty()){

            while(!q1.isEmpty()){
                root = q1.poll();
                System.out.print(root.key+" ");
                if(root.left!=null)
                    q2.add(root.left);
                if(root.right!=null)
                    q2.add(root.right);
            }

            System.out.println();
            while(!q2.isEmpty()){
                root = q2.poll();
                System.out.print(root.key+" ");
                if(root.left!=null)
                    q1.add(root.left);
                if(root.right!=null)
                    q1.add(root.right);
            }
            System.out.println();
        }
    }

    public static void levelByLevelOneQueueUsingDelimiter(Node root){
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            root = q.poll();
            if(root!=null){
                System.out.print(root.key+" ");
                if(root.left!=null)
                    q.add(root.left);
                if(root.right!=null)
                    q.add(root.right);
            }else{
                if(!q.isEmpty()){
                    System.out.println();
                    q.add(null);
                }
            }
        }
    }

    public static void levelByLevelOneQueueUsingCount(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        int levelCount = 1;
        int currentCount = 0;
        q.add(root);
        while(!q.isEmpty()){
            while(levelCount > 0){
                root = q.poll();
                System.out.print(root.key+" ");
                if(root.left!=null){
                    currentCount++;
                    q.add(root.left);
                }
                if(root.right!=null){
                    currentCount++;
                    q.add(root.right);
                }
                levelCount--;
            }
            System.out.println();
            levelCount = currentCount;
            currentCount = 0;
        }
    }

    public static void main(String[] args) {

        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(5);
        System.out.println("Level By Level using two queues");
        levelByLevelTwoQueue(rootNode);
        System.out.println("Level By Level Using One Queue and null Delimiter");
        levelByLevelOneQueueUsingDelimiter(rootNode);
        System.out.println("Level By Level Using One Queue Level Count");
        levelByLevelOneQueueUsingCount(rootNode);
    }
}
