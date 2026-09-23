import java.util.*;
public class java223{
    public static void main(String args[]){
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        Iterator it = cities.iterator(); 
        while(it.hasNext()){
            System.out.println(it.next());//it will print and update to next value automatically


        }


        //avanced loop 
        for(String city: cities){
            System.out.println(city);
        }
    }
}