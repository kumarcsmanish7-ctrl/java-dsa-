import java.util.*;
public class java257 {
    static int n = 9 ;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    public static void init(){
        for(int i = 0 ;i<n;i++){
            par[i] = i ; 
        }
    }

    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x] = find(par[x]);// we are storing the leader directly by doing this par[x]
        // as the iteration changes the value of par[x] changes 
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA]==rank[parB]){
            par[parB] =parA;
            rank[parA]++;
        }
        else if(rank[parA]>rank[parB]){
            par[parB]= parA;
        }
        else{
            par[parA]= parB;
        }
    }

    // we can do one more optimization - path compression - we will store the ancestor here 

    public static void main(String args[]){
        init();
        System.out.println(find(3));
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
    }
}
