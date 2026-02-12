public class java112 {
    public static void main (String args[]){
        
    }
}
//base class
class Animal{
    String color;
    
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}
class Mammal extends Animal {
    void walk(){
        System.out.println("walks");
    }
}
class Fish extends Animal {
    void walk(){
        System.out.println("swims");
    }
}
class Birds extends Animal {
    void walk(){
        System.out.println("flies");
    }
}