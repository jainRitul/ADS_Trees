
class Node {
    Node right;
    Node left;
    int data;
    Node(int x){
        right = left = null;
    }
}
public class CheckForBalancedTree {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.left.right = new Node(60);
        root.left.left = new Node(70);
        root.left.left.left = new Node(70);
        // root.left.left.left.right = new Node(70);
        System.out.println(isBalanced(root));
        System.out.println(isBalancedEfficient(root));
    }
    static int isBalancedEfficient(Node root){
        if(root == null) return 0;

        int lh = isBalancedEfficient(root.left);
        if(lh == -1) return -1;

        int rh = isBalancedEfficient(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh-rh) > 1) return -1;
        return Math.max(lh, rh) + 1;

    }
    static int height(Node root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh)+1;
    }
    static boolean isBalanced(Node root){
        if(root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);

        return (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }
}