package trees;

public class SearchKeyBST {
    public static void main(String[] args) {
        Node rootNode = new Node(50);
        rootNode.left = new Node(20);
        rootNode.right = new Node(30);
        rootNode.left.left=new Node(10);
        rootNode.left.right= new Node(15);
        Node searchResult = search(rootNode,10);
        Node searchResult2 = searchIterative(rootNode,10);
        System.out.println("searchResult2 = " + searchResult2);
        System.out.println("searchResult = " + searchResult);

    }

    public static Node search(Node root, int key) {

        if (root == null) {
            return null;
        }

        if (root.key == key) {
            return root;
        } else if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node searchIterative(Node root, int key) {
        while (root != null) {
            if(key > root.key)
                root = root.right;
            else if(key < root.key)
                root = root.left;
            else
                return root;
        }
        return null;
    }
}
