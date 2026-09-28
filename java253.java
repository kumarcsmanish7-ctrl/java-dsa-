public class java253 {
    public static boolean targetSumSubset(int arr[], int sum ){//O(n*sum)
        int n =arr.length;
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        for(int i = 0 ;i<n+1;i++){// if sum = 0 then the answer is always true , the col0 is true but the 0h row is false except dp[0][0]=true and in java by default it is initialize with false 
            dp[i][0] =true;// i items, j - sum 
        }
        //tabulation for nested loop 
        for(int i = 1;i<n+1;i++){
            for(int j =1;j<sum+1;j++){
                int  v= arr[i-1];
                //include 
                if(v<=j&& dp[i-1][j-v]==true){
                    dp[i][j] =true; 
                }
                //exclude 
                else if(dp[i-1][j]==true){// now only j not j-v because we have excluded weight
                    dp[i][j] =true;
                }
            }
        }
        printdp(dp);
        return dp[n][sum];
    }
    public static void printdp(boolean dp[][]){
        for(int i = 0 ;i<dp.length;i++){
            for(int j = 0 ;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[] = { 4,2,7,1,3};
        int sum = 10;
        System.out.println(targetSumSubset(arr, sum));

    }
}
