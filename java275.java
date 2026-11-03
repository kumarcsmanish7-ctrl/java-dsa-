import java.util.*;
public class java275{//tabulation
    //mountain and rangess -same as the code of catalon

    //O(n^2)
    public static int mountainandranges(int n){
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;//initialization

        for(int i=2;i<=n;i++){//Ci
            for(int j = 0 ;j<i;j++){
                dp[i]  += dp[j]*dp[i-j-1];
                //inside=dp[j]
                //outside=dp[i-j-1]
            }
        }
        return dp[n];

        
    }
    public static void main(String args[]){
        int n =4;        
        System.out.println(mountainandranges(n));
    }
}