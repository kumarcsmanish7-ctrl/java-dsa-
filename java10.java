import java.util.*; //don't  forget this to include
public class java10 { 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float rad = sc.nextFloat();
        float area = 3.14f * rad * rad; 
        // 3.14 is considered as double here so take f to make it float
        System.out.println(area);
    }
}