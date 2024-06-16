class  Node {
    int data;
    Node left;
    Node right;
    Node(int x){
        data = x;
        left = right = null;
    }
}
public class CountNodeInCompleteBinaryTree {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
        System.out.println(countNodes(root));//o(n)
        System.out.print(countNodesEfficient(root));//log(n) * log(n)
    }
    static int countNodesEfficient(Node root){
        int lh = 0;int rh= 0;
        Node curr = root;
        while(curr != null){
            curr = curr.left;
            lh++;
        }
        curr = root;
        while(curr != null){
            curr = curr.right;
            rh++;
        }
        if(lh == rh){
            return (int)(Math.pow(2,lh)) -1;
        }

        return 1+countNodesEfficient(root.left) +countNodesEfficient(root.right);
    }
    static int count = 0;
    static int countNodes(Node root){
        if(root == null) return 0;
        
       
        return 1+countNodes(root.left) + countNodes(root.right);
    }
}
