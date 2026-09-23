import java.util.*;
public class java236 {// starts with problem

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false ; // not nessary as it is not used anywhere
        int freq;
        public Node(){
            for(int i =0;i<26;i++){
                children[i] = null;
            }
            freq = 1; // starting the frequency as 1
        }
    }
    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i =0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();

            }
            else{
                curr.children[idx].freq++;
            }
            curr =curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans){//O(L) longest word
        // we are making a recursive function on the root not on the word 
        //base case 
        if(root== null){
            return ; 
        }
        if(root.freq==1){
            System.out.println(ans);
            return ; 
        }
        for(int i =0;i<root.children.length;i++){//root.children.length =26
            if(root.children[i]!=null){
                findPrefix(root.children[i],ans+(char)(i+'a'));
            }
        }
    }

    public static boolean startsWith(String prefix){//O(L)
        Node curr = root;
        for(int i =0;i<prefix.length();i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }


    public static int countNode(Node root){
        if(root== null){
            return 0;
        }
        int count =0;
        for(int i =0;i<26;i++){
            if(root.children[i]!= null){
                count+=countNode(root.children[i]);
            }
        
        }
        return count+1;//count all the children with the root node 
    }
    public static void main(String args[]){
        String str="ababa";//ans = 10
        //suffix => insert in trie 
        for(int i=0;i<str.length();i++){
            String suffix = str.substring(i);//start from i and go till last
            insert(suffix);
        }
        System.out.println(countNode(root));
        
       
    }
}
