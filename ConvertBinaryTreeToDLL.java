class Node {
    Node right;
    Node left;
    int data;
    Node(int x){
        data = x;
        right = left = null;
    }
}
public class ConvertBinaryTreeToDLL {
    static Node prev = null;
    static Node head = null;
    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(5);
    	root.right=new Node(20);
    	root.right.left=new Node(30);
        root.right.right=new Node(35);
      

        Node head = BinaryTreeToDll(root);

        printList(head);
    }
    static void printList(Node head){
     
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
    }
    static Node BinaryTreeToDll(Node root)
    {
        if(root == null ) return root;
     
        BinaryTreeToDll(root.left);
        
        if(prev == null) {head = root;}
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        BinaryTreeToDll(root.right);

        return head;
    }
}
