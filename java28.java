//printing numbers from 1 to n 
import java.util.*;
public class java28{ 

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        int sum =0;
        while (i<=n){
            sum +=i;        
            i++;
        }
        System.out.print("sum is " + sum);

     }
}