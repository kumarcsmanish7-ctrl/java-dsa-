import java.util.*;
class java24 { 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a : ");
        int a = sc.nextInt();
        System.out.println("enter b:");
        int b = sc.nextInt();
        char operator = sc.next().charAt(0);
        //sc.next makes operator as string to avoid we use .charAt(0)
        switch (operator){
            case '+': System.out.println(a+b);break ;
            case '-': System.out.println(a-b);break ;
            case '*': System.out.println(a*b);break ;
            case '/': System.out.println(a/b);break ;
            case '%': System.out.println(a%b);break ;
            default:System.out.println("wrong operator");

        }


    }
}