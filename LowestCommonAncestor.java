import java.util.ArrayList;

class Node {
    Node right;
    Node left;
    int data;
    Node(int x){
        data = x;
        right = left = null;
    }
}
class LowestCommonAncestor{
    public static void main(String[] args) {
      
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	int n1=10,n2=50;

        System.out.println(LCA(root,n1,n2).data);
    }
    static boolean findPath(ArrayList<Node>a , int x,Node root){
        if(root == null) return false;

        a.add(root);
        if(root.data == x) return true;
        if(findPath(a, x, root.left) || findPath(a, x, root.right))
           return true;
         
        a.remove(a.size()-1);   
        return false; 
    }
    static Node LCA(Node root , int n1,int n2){
        if(root == null) return null;

        ArrayList<Node>p1 = new ArrayList<>();
        ArrayList<Node>p2 = new ArrayList<>();

        if(!findPath(p1,n1,root) || !findPath(p2,n2,root)) return null;
        int i=0;
        for(i = 0;i<p1.size() && i<p2.size();i++){
            if(!p1.get(i).equals(p2.get(i))) break;
        }
        return p1.get(i-1);
    }
}