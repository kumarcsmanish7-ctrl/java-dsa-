import java.util.*;
public class java190 {
    public static void main ( String args[]){
        int a[]={1,2,3};
        int b[]={2,1,3};
        Arrays.sort(a);
        Arrays.sort(b);
        int mindif = 0;
        for(int i =0;i<a.length;i++){
            mindif= Math.abs(a[i]-b[i]);
        }
        System.out.println("min absolute diff of pairs:"+mindif);
    }
}
