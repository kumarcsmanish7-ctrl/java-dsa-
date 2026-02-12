public class java116 {
    public static void main (String args[]){
        Horse h = new Horse();
        h.eat();
        h.walk();

        Chicken c = new Chicken();
        c.eat();
        c.walk();
        //we cannot create abstaract classes object, we will get a error 
        //Animal a = new Animal();
        System.out.println(h.color);//by default the color is brown
        //jab be child class ki constructor call hota he to uska parent class call hota he 
        

        Mustang myHorse = new Mustang();
        // heiarcy //    important
        //Animal -> Horse -> Mustang 

    }
    
}
abstract class Animal{
    //making a constructor inside abstract class 
    String color ; 
    Animal(){
        color = "brown";
    }

    void eat(){
        System.out.println("animal eats");
    }
    abstract void walk();//animal ne idea de diya implementatin nahi diya
    //we have to declare in the subclasses
}
class Horse extends Animal{
    Horse(){
        System.out.println("horse constructor called");
    }

    //using a constructor 
    void changeColor(){
        color = "dark brown";
    }
     //if we declare subclass then we have to declare the walk()
    void walk(){
        System.out.println("walks on 4 legs");
    }
}

class Mustang extends Horse{
    Mustang() {
        System.out.println("")

    }
}
class Chicken extends Animal {
    void changeColor(){
        color = "white";
    }


    void walk(){
        System.out.println("walks on 2 legs");
    }
}