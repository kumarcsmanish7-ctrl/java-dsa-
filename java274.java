import java.util.*;
public class java274{//tabulation
    //O(n^2)
    public static int countbst(int n){
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;//initialization

        for(int i=2;i<=n;i++){//Ci
            for(int j = 0 ;j<i;j++){
                int left = dp[j];//arranging left subtree
                int right = dp[i-j-1];//arranging the rightsubtree
                dp[i]  += left*right;//same code as catalon
            }
        }
        return dp[n];

        
    }
    public static void main(String args[]){
        int n =4;        
        System.out.println(countbst(n));
    }
}