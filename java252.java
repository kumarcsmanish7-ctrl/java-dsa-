public class java252 {
    //O(nW)
   
    public static void printdp ( int dp[][] ){
        for(int i = 0 ;i<dp.length;i++){
            for(int j  =  0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int knapsackTab(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        //initialize with 0 for the 0 row and 0 col
        for(int i = 0 ; i<dp.length;i++){//0th col
            dp[i][0]=0;
        }

        for(int j = 0 ;j<dp[0].length;j++){//0th row
            dp[0][j] = 0 ; 
        }
        for(int i = 1 ;i<n+1;i++){
            for(int j = 1; j<W+1;j++){// tabulation 
                int v = val[i-1];//ith item val
                int w = wt[i-1];// ith item wt
                if(w<= j ){//valid
                    int incProfit = v+dp[i-1][j-w];// included profit 
                    int excProfit  = dp[i-1][j];// exclude profit 
                    dp[i][j] = Math.max(incProfit , excProfit);
                }
                else{// invalid where w > j , j is the allowed weight
                    int excProfit  = dp[i-1][j];
                    dp[i][j]  = excProfit;
                }
            }
        }
        printdp(dp);
        return dp[n][W];
       

        
    }
    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(knapsackTab(val , wt, W));
    }
}
