public class java87 {
    public static void main (String args[]){
        String s1 = "tony";
        String s2 = "tony";
        String s3 = new String("tony");
        if(s1==s2){//equal 
            System.out.println("strings are equal");
        }
        else {
            System.out.print("Strings are not equal");
        }
        if(s1==s3){//not equal
            System.out.println("strings are equal");
        }
        else {
            System.out.print("Strings are not equal");
        }
        if (s1.equals(s3)){
            System.out.println("Strings are equal");
        }
        else{
            System.out.println("strings are not equal");
        }
    }
    
}
