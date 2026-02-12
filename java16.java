public class java16 {
    public static void main(String args[]){
        int age =16;
        if(age>=18){
            System.out.println("adult:");
        }
        //if age>18 is true then the other down if condition will also be executed
        if(age>=13 &&age<18){
            System.out.println("adult:");
        }
        else{
            System.out.println("not adult");

        }
    }
}
