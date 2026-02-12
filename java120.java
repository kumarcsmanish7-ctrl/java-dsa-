public class java120 {
    public static void main(String args[]){
        Horse h = new Horse();
        System.out.println(h.color);
    }
}
class Animal{
    String color;
    Animal(){
        System.out.println("animal constructor is called");
    }
}
class Horse extends Animal{
    Horse(){
        super.color = "brown";
       // super();//by this animal class constructor is called 
        System.out.println("horse constructor is called");
    }
}
