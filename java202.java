import java.util.ArrayList;
public class java202 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void printpath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void printroot2leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return ;
        }
        path.add(root.data);
        if(root.left == null&& root.right == null){
            printpath(path);
        }
        printroot2leaf(root.left,path);
        printroot2leaf(root.right,path);
        path.remove(path.size()-1);
    }

    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        printroot2leaf(root,new ArrayList<>());
    }
}