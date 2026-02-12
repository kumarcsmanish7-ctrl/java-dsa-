import java.util.*;
public class java33{ 

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =1;i<=5;i++){
            if(i==3){
                break;
            }
            System.out.println(i);
        }
            System.out.println("i am out of the loop");

     }
}