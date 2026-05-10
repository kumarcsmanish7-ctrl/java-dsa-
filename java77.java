import java.util.Collections;//with this the code didnot work 
import java.util.Arrays;
public class java77{
    public static void printArr(Integer arr[]){
        for(int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //java uses comparitors for reversing the order
    public static int compare (int a , int b ){
        //a<b -ve 
        // a == b  0 
        // a > b +ve 
        return a-b ; 

    }
    public static void main (String args []){
        Integer arr[]= {5,4,1,3,2};//this array is a 
        //object of Integer class  for reverseOrder() , primitive int do not work with this 
        //Arrays.sort(arr,Collections.reverseOrder());
        Arrays.sort(arr,0,3,Collections.reverseOrder());
        printArr(arr);
    }

} 
