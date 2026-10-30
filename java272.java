import java.util.*;
public class java272{//memorization
    
    public static int catalanmem(int n,int[] dp){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans = 0 ;
        for(int i =0; i<=n-1;i++){
            ans+= catalanmem(i,dp)*catalanmem(n-i-1,dp);
            dp[i] =ans;
        }
        return dp[n]=ans;

    }
    public static void main(String args[]){
        int n =4;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        // for(int i = 0 ; i<n+1;i++){
        //     dp[i]=-1;
        // }
        System.out.println(catalanmem(n,dp));
    }
}