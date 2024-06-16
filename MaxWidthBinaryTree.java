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
public class MaxWidthBinaryTree {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.left=new Node(60);
    	

        System.out.println(maxWidth(root));
    }
    static int maxWidth(Node root){
        if(root == null) return 0;

        Queue<Node>q = new ArrayDeque<>();
        q.add(root);
        int maxSize = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int levelSize = q.size();
            maxSize = Math.max(maxSize,levelSize);

            for(int i = 0;i<levelSize;i++){
                Node curr = q.poll();
                if(curr.left != null) q.add(curr.left);  
                if(curr.right != null) q.add(curr.right);  
            }
        }return maxSize;
    }
  
}
