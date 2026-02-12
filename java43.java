import java.util.*;
public class java43 {
    public static int printHelloWorld(){
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        return 3;
    }
    public static int calculateSum(int num1 , int num2 ){
        //function defination is called parameter or formal parameters  
        
        int sum = num1+num2 ;
        System.out.println("sum is :"+sum);
        return sum ; 
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = calculateSum(a , b ); 
        //function call a and b are arguments or actual parameters
        System.out.println("sum is "+sum);      
    }
}
