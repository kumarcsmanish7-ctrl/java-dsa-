public class java248 {//dynamic programming
     public static int fib(int n , int[] f){//O(n  )
        if(n == 0 || n ==1){
            return n;
        }

        //check for nth level whether the fib is calculated
        if(f[n]!= 0){//fib(n) is already calculated 
            return f[n];
        }

        // if not calculated calculate it and return f[n]
        f[n] =fib(n-1,f)+fib(n-2,f);
        return f[n];
     }

    public static int fibTabulation(int n){
        int dp[] = new int[n+1];
        dp[1] = 1;
        // dp[0] = 0;

        for(int i = 2 ;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];// ans 
    }
    public static void main(String args[]){
        int n = 5; 
        int f[]= new int[n+1];// we calculate fibonaci from 0 to n , so the size should be n+1
        //by default 0 is stored in the array 
        System.out.println(fib(n, f));

        System.out.println(fibTabulation(n));
    }
    
}
 