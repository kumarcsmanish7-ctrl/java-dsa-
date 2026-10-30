import java.util.*;
public class java270 {
    public static boolean wildcard(String s,String p){
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        //boolean array is initialized with false in java 

        //initialize
        dp[0][0]=true;
        for(int i =1;i<n+1;i++){//j==0,pattern =0 
            dp[i][0]= false;
        }
        //s=" "
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
                //ith char==jth char || jth chat == ?
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }

                //last char ==*
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];//match with the last s chars retaing the * || ignore the * and compare 
                }
                else{
                    //rest all cases 

                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
    
    public static void main(String args[]){
        String s = "baaabab";
        String p = "*****ba******ab";//true
        System.out.println(wildcard(s,p));
    }
}
