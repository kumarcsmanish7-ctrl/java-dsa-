import java.util.*;
public class java197 {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root){
        if(root ==null){
            return 0;
        }
        int lh =height(root.left);
        int rh = height(root.right);

        return Math.max(lh,rh)+1;
    } 
    
    public static int diameter1(Node root){
        if(root == null){
            return 0;
        }
        int leftDiam = diameter1(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter1(root.right);
        int rightHt = height(root.right);
        int selfDia =leftHt+rightHt+1;
        return Math.max(selfDia, Math.max(leftDiam,rightDiam));


    }

    //O(n)
    public class info{
        int diam;
        int ht;
        public info(int diam, int ht){
            this.diam =diam;
            this.ht = ht;
        }
    }
    public static info diameter(Node root){
        if(root==null){
            return new Info(0,0);
        }
        info leftinfo = diameter(root.left);
        info rightinfo = diameter(root.right);
        int diam = Math.max(Math.max(leftinfo.diam,rightinfo.diam), leftinfo.ht+rightinfo.ht+1);
        int ht = Math.max(leftinfo.ht,rightinfo.ht)+1;
        return new info(diam,ht);
    }
    
    public static boolean isidentical(Node node , Node subroot){
        if(node==null&&subroot==null){
            return true;
        }
        else if(node==null|| subroot==null||node.data!=subroot.data){//check third condition important
            //3rd condition dono ka data same nahi he
            return false;
        }
        if(!isidentical(node.left,subroot.left)){
            return false;
        }
        if(!isidentical(node.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean issubtree(Node root, Node subRoot){
        if(root==null){//base case
            return false;
        }
        if(root.data== subRoot.data){
            if(isidentical(root,subRoot)){
            return true;
            }
        }
        
        return issubtree(root.left,subRoot)||issubtree(root.right,subRoot);//check only left subtree if its one then it wont check the other condition 
        }
    
    static class IInfo{
        Node node;
        int hd;
        public IInfo(Node node, int hd ){//constructor
            this.node =node;
            this.hd = hd;
        }
    }
    
    public static void topview(Node root){
        //level order
        Queue<IInfo> q = new LinkedList<>(); 
        HashMap<Integer,Node> map = new HashMap<>();
        int min =0, max =0;
        q.add(new IInfo(root,0));
        q.add(null);//level order traversal ka basic code clear hona chaheye 

        while(!q.isEmpty()){
            IInfo curr =q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    
                if(!map.containsKey(curr.hd)){//checks whether the key is present ->return true
                    //first time my hd is occuring 
                    map.put(curr.hd,curr.node);//important condition
                            
                }  
                if(curr.node.left!=null){
                    q.add(new IInfo(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }  
                if(curr.node.right!=null){
                    q.add(new IInfo(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
                }
               
            }
            //to print 
            for(int i =min;i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }System.out.println();

        }

    }

    public static void kLevel(Node root , int level, int k){
        if(root==null){
            return;
        }
        if(level == k ){
            System.out.print(root.data+" ");
            return;
        }
        kLevel(root.left, level+1,k);
        kLevel(root.right, level+1, k);
    }
    
    //lowest common anscestor

    public static boolean getPathg(Node root,int n,ArrayList<Node> path ){//O(n)
        if(root ==null){//base case 
            return false;
            }
        path.add(root);
        if(root.data==n){
            return true ; 
        }
        boolean foundleft = getPathg(root.left, n , path);
        boolean foundright = getPathg(root.right, n , path);
        if(foundleft|| foundright){
            return true ; 
        }
        path.remove(path.size()-1);
        return false ;
    }
    public static Node lca(Node root,int n1,int n2){//O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPathg(root,n1,path1);
        getPathg(root,n2,path2);
        //last common ancestor 
        int i =0;
        for(;i<path1.size()&& i<path2.size();i++){
            if(path1.get(i)!= path2.get(i)){
                break;
            }
        }
        //last equal node -> i -1th node 
        Node lca = path1.get(i-1);
        return lca;
    }

    //approach 2 
    public static Node lca2(Node root, int n1, int n2){
        
        if(root == null|| root.data == n1 || root.data == n2){
            return root ;
        }
        Node leftlca= lca2(root.left , n1, n2);
        Node rightlca = lca2(root.right, n1, n2);
        //leftlca = val right lca =null
        if(rightlca ==null){
            return leftlca ;
        }
        if(leftlca == null){
            return rightlca;
        }
        return root ;
    }


    //minimum distance between the nodes 
    public static int lcaDist(Node root,int n){
        if(root ==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDist =lcaDist(root.left,n);
        int rightDist=lcaDist(root.right,n);
        if(leftDist ==-1&& rightDist ==-1){
            return -1;
        }
        else if(leftDist ==-1){
            return rightDist+1;
        }
        else{
            return leftDist+1;

        }
    }
    public static int MinDist(Node root,int n1,int n2){
        Node lca  =lca2(root,n1,n2);
        int dist1 = lcaDist(lca, n1 );
        int dist2 = lcaDist(lca,n2);
        return dist1+dist2;
    }

    //kth ansector
    public static int KAncestor(Node root,int n , int k ){
        if(root== null){//base case 
            return -1;
        }
        if(root.data == n ){
            return 0;
        }
        int leftDist = KAncestor(root.left, n,k);
        int rightDist = KAncestor(root.right,n,k);
        if(leftDist==-1&&rightDist==-1){
            return -1;
        }
        int max = Math.max(leftDist, rightDist );
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }


    //O(n)
    public static int transform(Node root){
        if(root==null){
            return 0;
        }
        int leftchild = transform(root.left);
        int rightchild = transform(root.right);
        int data = root.data;
        int newleft = root.left == null ? 0: root.left.data;
        int newright = root.right == null? 0: root.right.data;
        root.data = leftchild + newleft + newright +rightchild;
        return data;
    }

    public static void main(String args[]){
        /*
        1
       / \
       2  3
      / \ / \
      4 5 6 7
       */
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
      root.right.left = new Node(6);
      root.right.right = new Node(7);
    
      System.out.println(height(root));
      System.out.println(diameter(root));
      System.out.println(diameter(root).diam);//returns information object 
    
/*
        2
        /\
        4 5
*/
      Node subRoot = new Node(2);
      subRoot.left = new Node(4);
      subRoot.right = new Node(5);

    System.out.println(issubtree(root, subRoot));
    topview(root);

    int k =2;
    kLevel(root,1,k); // is the root level
    int n1 =4, n2 = 5;
    System.out.println(lca(root,n1,n2).data);
    System.out.println(lca2 (root,n1,n2).data);
    System.out.println(MinDist(root,n1,n2));
    }
}
