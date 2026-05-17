import java.util.ArrayList;
public class java205{
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void preorder(Node root){
        if(root ==null){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //creating bst from sorted sequence of a array 
    public static Node createBST(int arr[],int st, int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr,st,mid-1);
        root.right= createBST(arr,mid+1,end);
        return root;
    }





    //create balanced bst from bst
    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);

    }
    public static Node createBSTfromAL( ArrayList<Integer> inorder, int st, int end){
        if(st>end){
            return null;
        }
        int mid = st+(end-st)/2;
        Node root = new Node(inorder.get(mid));
        root.left= createBSTfromAL(inorder, st, mid-1);
        root.right = createBSTfromAL(inorder, mid+1, end);
        return root;
    }
    public static Node balancedBST(Node root){//O(n)
        //storing inorder sequence 
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root,inorder);
        root =createBSTfromAL(inorder,0,inorder.size()-1 );

        return root;
    }
    
    public static void main(String args[]){
        int arr[] = {3,5,6,8,10,11,12};
        
        Node root = createBST(arr,0, arr.length-1);
        preorder(root);


        //call the program to run bst to balancedbst

    }
}