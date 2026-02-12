public class java130 {
    public static int optimizedPower(int a , int n){
        if(n==0){
            return 1;
        }
        int halfPower = optimizedPower(a,n/2);
        int halfPowerSq = a* halfPower* halfPower;//timecomplexity is o(logn)


        //int halfPowerSq = optimizedPower(a,n/2)*optimizedPower(a,n/2);
        //in the above the time complexity is o(n) because the function is called twice




        // n is odd
        if(n%2 !=0){
            halfPowerSq = a* halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String args[]){
        int a =2;
        int n =10;
        System.out.println(optimizedPower(a,n));
    }
}
