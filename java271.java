import java.util.*;
public class java271{//recursion
    public static int catalanRecursion(int n){
        if(n==0||n==1){
            return 1;
        }
        int ans = 0 ;
        for(int i = 0 ; i<=n-1;i++){
            ans+= catalanRecursion(i)*catalanRecursion(n-i-1);
        }
        return ans;

    }
    public static void main(String args[]){
        int n =4;
        System.out.println(catalanRecursion(n));
    }
}