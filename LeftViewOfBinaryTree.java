import java.util.ArrayDeque;
import java.util.Queue;

class  Node {
    int data;
    Node left;
    Node right;
    Node(int x){
        data = x;
        left = right = null;
    }
}
public class LeftViewOfBinaryTree {
    static int maxLevel = 0;
    public static void main(String[] args) {
        
        Node head = new Node(10);
        head.left = new Node(20);
        head.right = new Node(30);
        head.left.left = new Node(40);
        head.left.right = new Node(50);
        head.right.left = new Node(60);
        head.right.right = new Node(70);
        
        leftView(head);
        leftViewIterative(head);
    }
    static void leftViewIterative(Node root){
        if(root == null) return ;
        Queue<Node>q=new ArrayDeque<>();

        q.add(root);
        while(!q.isEmpty()){
           int levelSize = q.size();
           
           for(int i = 0;i<levelSize;i++){
               Node curr = q.poll();
               if(i==0) System.out.print(curr.data + " ");
             

               if(curr.left != null) q.add(curr.left);
               if(curr.right != null) q.add(curr.right);
           }
        }
    }
    static void printLeft(Node root,int level){
        if(root == null)
          return ;

        if(maxLevel  < level){
            System.out.print(root.data+" ");
            maxLevel = level;
        }  

        printLeft(root.left,level+1);
        printLeft(root.right,level+1);
    }
    static void leftView(Node root){
        printLeft(root , 1);
        System.out.println();
    }
}
