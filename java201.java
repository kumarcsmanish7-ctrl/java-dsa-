public class java201 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }


    public static void printInrange(Node root, int k1, int k2 ){
        if(root == null){
            return;
        }
        if(root.data>= k1 && root.data<=k2){
            printInrange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInrange(root.right,k1,k2);
        }
        else if(root.data<k1){
            printInrange(root.left,k1,k2);
        }
        else{
            printInrange(root.right,k1,k2);
        }
    }
    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        printInrange(root, 5,7);
        
    }
}