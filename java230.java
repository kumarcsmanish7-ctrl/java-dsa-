import java.util.*;
public class java230 {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false ;

        //constructor
        Node(){
            for(int i = 0 ;i<26;i++){
                children[i] = null;
            }
        }
    }

    public static Node root= new Node();// root is always empty 

    public static void main(String args[]){
        String words[] = { "the", "a", "there", "their", "any", "thee"};
    }
}
