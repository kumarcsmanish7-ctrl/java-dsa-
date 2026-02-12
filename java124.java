public class java124 {
    public static int sum(int n){
        if (n ==1){
            return 1;
        }
        int Snm1 = sum(n-1);
        int Sn = n + Snm1;
        return Sn;
    }
    public static void main(String args[]){
        System.out.println(sum(5));
    }
}
