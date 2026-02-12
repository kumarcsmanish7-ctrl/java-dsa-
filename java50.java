
public class java50 {
    public static boolean isPrime(int n){
        //boolean isPrime = true;  no need of this variable



        // corner case for 2
        if (n ==2){
            return true;//if here return is given then 
            // the code does go for the for loop to check 

        }

        for(int i =2; i <=Math.sqrt(n); i++){//completely dividing
            if(n%i==0){
                //isPrime = false;// we can also write 
                //return isPrime ;//we can also use break;
                return false ;// instead of two line code
            }

        }
        //return isPrime;
       return true;//by this we are reducing an extra variable

    }
    
    public static void main(String args[]){  
        System.out.println(isPrime(5));
        
                    
    }
}
