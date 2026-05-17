import java.util.ArrayList;
public class java204 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node mirrortree(Node root){//O(n)
        if(root ==null){
            return null;
        }
        Node leftmirror = mirrortree(root.left);
        Node rightmirror = mirrortree(root.right);
        root.left = rightmirror;
        root.right = leftmirror;
        return root;
    }
    public static void preorder(Node root){
        if(root ==null){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        root =mirrortree(root);
        preorder(root);
    }
}