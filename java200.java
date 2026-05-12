public class java200 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static Node delete(Node root, int val){
        if(root.data <val){
            root.right = delete(root.right,val);
        }
        else if(root.data>val){
            root.left = delete(root.right,val);
        }
        else{//voila  root ==val
            //case 1 - leaf node 
            if(root.left== null && root.right==null){
                return null;
            }
            else if (root.left == null){//case2 - single child
                return root.right; 
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3  --both children 
            Node inordersuccessor =  findInorderSuccessor(root.right);
            root.data = inordersuccessor.data;
            root.right = delete(root.right, inordersuccessor.data);

        }return root ;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left!= null){
            root = root.left;
        }
        return root;
    }
    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        root = delete(root,1);
        System.out.println();//use inorder traversel to check the bst
        
    }
}