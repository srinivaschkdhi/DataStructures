public class SumTree { 
    public int isSumTree(Node node){
        if(node == null || (node.left == null && node.right == null))
            return 1;
        
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        
        if( (node.data == leftSum + rightSum)
           && isSumTree(node.left) != 0
           && isSumTree(node.right) != 0)
            return 1;
        
        return 0;
    }

    private static int sum(Node node){
        if(node == null)
            return 0;

        return sum(node.left) +  node.data + sum(node.right);
    }
}


// SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree
//                    26
//                  /   \
//                10     3
//              /    \     \
//            4      6      3
