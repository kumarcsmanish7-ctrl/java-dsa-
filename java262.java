public class java262 {
    public static int lcs(String str1,int n,String str2,int m){
        if(n==0 || m==0){
            return 0 ;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return lcs(str1,n-1,str2,m-1)+1;
        }
        else{
            return Math.max(lcs(str1,n-1,str2,m),lcs(str1,n,str2,m-1));
        }
    }

    //lcs2 memorization 
    public static int lcs2(String str1,int n,String str2,int m,int dp[][]){
        if(n==0 || m==0){
            return 0 ;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return dp[n][m] =lcs2(str1,n-1,str2,m-1,dp)+1;
        }
        else{
            return dp[n][m]= Math.max(lcs2(str1,n-1,str2,m,dp),lcs2(str1,n,str2,m-1,dp));
        }
    }


    public static int lcsTab(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        //initialize
        for(int i = 0 ;i<n+1;i++){
            for(int j =0 ;j<m+1;j++){
                if(i==0|| j==0){
                    dp[i][j]=0;
                }
            }
        }

        //tabulation
        for(int i = 1; i<n+1;i++){
            for(int j =1 ;j<m+1;j++){
                if(str1.charAt(i-1)== str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;// +1 because we are counting the same character
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
        
    }
    public static void main(String args[]){
        String str1= "abcdge";
        String str2 = "abedg";//lcs ="sbdg" ; length =4
        int n = str1.length();
        int m= str2.length();
        System.out.println(lcs(str1,n,str2,m));

        int dp[][] = new int[n+1][m+1];
        for(int i =0;i<n+1;i++){//initalization
            for(int j=0;j<m+1;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(lcs2(str1,n,str2,m,dp));

        System.out.println(lcsTab(str1,str2));
    }
}
