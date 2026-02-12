public class java44 {
    public static void swap(int a , int b){
        //swap - values exchange 
       
        int temp = a; 
        a =b ;
        b = temp ; 
       //if we use print here we get a = 10 
       // and b = 5 
    }
    
    public static void main(String args[]){
         int a = 5; 
        int b = 10;
        swap(a, b );
        System.out.println("a = "+ a );
        // the value does not change 
        // because copy is made of a 
        System.out.println("b ="+b);
        // the value of a is 5 and value of b is 10
              
    }
}
