import java.util.ArrayList;
public class java203 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static boolean isvalidBST(Node root,Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data<= min.data){
            return false ;
        }
        else if (max!= null && root.data>max.data){
            return false ;
        }
        return isvalidBST(root.left, min, root)&& 
        isvalidBST(root.right,root,max);
    }

    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        if(isvalidBST(root,null,null)){
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }
        
    }
}