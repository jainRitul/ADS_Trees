class Node {
    Node right;
    Node left;
    int data;
    Node(int x){
        data = x;
        right = left = null;
    }
}
public class ConstructBinaryTreeWithInorderAndPreOrder 
{
    public static void main(String[] args) {
      int inorder[] = {20,10,30};   
      int preorder[] = {10,20,30};  
      
     Node root =  construcTree(inorder,preorder,0,inorder.length-1);
     printTree(root);
    }
    static void printTree(Node root){
        if(root == null) return ;
        System.out.print(root.data+" ");
        printTree(root.left);

        printTree(root.right);
    }

    static int preOrder  = 0;
    static Node construcTree(int in[],int pre[],int is,int ie){
        if(is > ie) return null;

        Node root = new Node(pre[preOrder++]);
        int index = -1;
        for(int i = is ; i<= ie;i++){
            if(in[i] == root.data){
                index = i;
                break;
            }
        }

        root.left = construcTree(in, pre, is, index-1);
        root.right = construcTree(in, pre, index+1,ie);

        return root;
    }
}