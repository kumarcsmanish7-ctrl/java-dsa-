public class java47 {
    public static int fact(int n){
        int f=1 ;
        for(int i =1; i<= n ; i++){
            f=f*i;
        }
        return f;//factorial of n 
         
    }
    public static int binCoeff(int n ,int r){
        int nfact = fact(n);
        int rfact = fact(r);
        int nmrfact = fact(n-r);
        int bincoffe = (nfact)/(rfact*nmrfact);
        return bincoffe;
    }
    
    public static void main(String args[]){  
        System.out.println(binCoeff(5,2));
                    
    }
}
