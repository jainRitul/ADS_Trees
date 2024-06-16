
class  Node {
    int data;
    Node left;
    Node right;
    Node(int x){
        data = x;
        left = right = null;
    }
}
public class ChildernSumProperty {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);
        root.right.left = new Node(9);
        root.right.right = new Node(3);
        System.out.println(childernSum(root));
    }
    static boolean childernSum(Node root){
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        
        
        int sum = 0;
        if(root.left != null) sum += root.left.data;
        if(root.right != null) sum += root.right.data;

        return (root.data == sum && childernSum(root.left) && childernSum(root.right));
    }
    
}
