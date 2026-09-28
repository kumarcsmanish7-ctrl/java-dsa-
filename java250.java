public class java250 {
    public static int knapsack(int val[],int wt[] , int W ,int n ){//n is the object that is taken
        if(W==0||n == 0){// W - capacity is 0 or n - no of items = 0 
            return 0;
        }
        if(wt[n-1]<=W){//valid, n-1 gives me the index no
            //include 
            int ans1 = val[n-1]+knapsack(val,wt,W-wt[n-1], n-1);// capacity decrases by wt[n-1] and no of items decreases by 1

            //exclude
            int ans2 = knapsack(val,wt,W,n-1);
            return Math.max(ans1,ans2);//checking whether including it gives max val, or excluding it gives the max profit
            }
        else{//not valid
            return knapsack(val,wt,W,n-1);

        }
    }
    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(knapsack(val,wt,W,val.length));
    }
}
