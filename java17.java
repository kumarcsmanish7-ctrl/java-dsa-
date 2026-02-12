public class java17 {
    public static void main(String args[]){
        int age =16;
        if(age>=18){
            System.out.println("adult:");
        }
        //else if will be skipped if if is executed 
        else if(age>=13 &&age<18){
            System.out.println("adult:");
        }
        else{
            System.out.println("not adult");

        }
    }
}
