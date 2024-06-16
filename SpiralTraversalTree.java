import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    TreeNode  right;
    TreeNode  left;
    int data;
    TreeNode(int x){
        data = x;
        right = left = null;
    }
}
public class SpiralTraversalTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode (10);
        root.left = new TreeNode (20);
        root.right = new TreeNode (30);
        root.right.left = new TreeNode (40);
        root.right.right = new TreeNode (50);
        root.left.right = new TreeNode (60);

        sprialTraversalEfficient(root);
        // spiralTraversal(root);
    }
    static void sprialTraversalEfficient(TreeNode root){
        if(root == null) return;

        Stack<TreeNode>s1 = new Stack<>();
        Stack<TreeNode>s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                TreeNode curr = s1.pop();

                System.out.print(curr.data+" ");
               if(curr.left != null) s2.push(curr.left);
              if(curr.right!=null)  s2.push(curr.right);
               
                
            }
            while(!s2.isEmpty()){
                TreeNode curr = s2.pop();

                System.out.print(curr.data+" ");
               if(curr.right!=null) s1.push(curr.right);
               if(curr.left!=null) s1.push(curr.left);
                
            }
        }
    }
    static void spiralTraversal(TreeNode root){
        if(root == null) return;

        Queue<TreeNode >q=new ArrayDeque<>();
        Stack<TreeNode>s = new Stack<>();    
        q.add(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int levelSize = q.size();

            for(int i = 0;i<levelSize;i++){
                TreeNode  curr = q.poll();
                if(reverse){
                    s.push(curr);
                }else System.out.print(curr.data +" ");


                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(reverse){
            while(!s.isEmpty()){
                TreeNode curr = s.pop();
                System.out.print(curr.data + " ");
            }}
            reverse = !reverse;
        }
    }
}
