public class java94 {
    public static void BitManipulation(int n){
        int bitMask =1;
        if((n & bitMask) == 0){
            //even number
            System.out.println("even number");

        }
        else{
            System.out.println("odd number");
        }

    }
    public static void main (String args[]){
        BitManipulation(3);
        BitManipulation(11);
        BitManipulation(14);


    }
    
}
