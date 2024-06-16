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
class LevelOrderTraversalLineByLine{
    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(20);
        head.right = new Node(30);
        head.left.left = new Node(40);
        head.left.right = new Node(50);
        head.right.left = new Node(60);
        head.right.right = new Node(70);
        
        levelOrderTraversal(head);
    }
    static void levelOrderTraversal(Node head){
        if(head == null) return;
        Queue<Node>q = new ArrayDeque<>();

        q.add(head);
      
        while (!q.isEmpty()) {

           int levelSize = q.size();
           for(int i = 0;i<levelSize;i++){
                Node curr = q.poll();
                System.out.print(curr.data + " ");

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            System.out.println();
        }
    }
}