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
public class DeserializeBinaryTree {
    public static void main(String[] args) {
       
    	int []arr = {10 ,20 ,30, -1, 40, -1, -1, -1, -1 };
        Node root = deserialize(arr);
        System.out.println(root.data);
    }
   
    static int index = 0;
    static Node deserialize(int[] arr){
         if(arr.length == index ) return null;

         int val = arr[index];
         if(val == -1) return null;
         index++;
         Node root = new Node(val);
         root.left=deserialize(arr);
         root.right = deserialize(arr);
         return root;


    }
}


