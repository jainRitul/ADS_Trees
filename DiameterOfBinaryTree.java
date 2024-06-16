class Node {
    Node right;
    Node left;
    int data;
    Node(int x){
        data = x;
        right = left = null;
    }
}
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
      
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(60);
	    root.right.left.left=new Node(50);
	    root.right.right.right=new Node(70);

        System.out.println(diameter(root));
        System.out.print(diametereEfficient(root));
    }
    static int res=0;
    static int diametereEfficient(Node root){
        if(root == null) return 0;
        
        int lh = diametereEfficient(root.left);
        int rh = diametereEfficient(root.right);

        res = Math.max(lh+rh+1,res);
        return 1 + Math.max(lh,rh);
    }
    static int height(Node root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh,rh) + 1;
    }
    static int maxHeight = Integer.MIN_VALUE;

    static int diameter(Node root){
        if(root == null) return 0;
    
        int lh = height(root.left);
        int rh = height(root.right);
        maxHeight = Math.max(maxHeight,lh+rh+1);
        
        diameter(root.left);
        diameter(root.right);

        return maxHeight;
    }
}
