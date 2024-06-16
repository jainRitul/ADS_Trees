import java.util.ArrayList;

class  Node {
    int data;
    Node left;
    Node right;
    Node(int x){
        data = x;
        left = right = null;
    }
}
public class SerializeBinaryTree {
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
        // root.right = new Node(30);
        root.left.left = new Node(30);
        root.left.left.right=new Node(40);
    	ArrayList<Integer>arr = new ArrayList<>();
        serialize(root,arr);
        for(int num :arr)
          System.out.print(num+" ");
    }
    static void  serialize(Node root,ArrayList<Integer>arr){
        if(root == null) {arr.add(-1);return;}

        arr.add(root.data);
        serialize(root.left, arr);
        serialize(root.right, arr);
    }
}
