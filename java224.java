import java.util.*;
public class java224{
    public static void main(String args[]){
    HashSet<String> cities = new HashSet<>();
    cities.add("Delhi");
    cities.add("Mumabai");
    cities.add("Noida");
    cities.add("Bengaluru");
    System.out.println(cities);

    LinkedHashSet lhs = new LinkedHashSet<>();
    lhs.add("Delhi");
    lhs.add("Mumabai");
    lhs.add("Noida");
    lhs.add("Bengaluru");
    System.out.println(lhs);
    lhs.remove("Delhi");
    System.out.println(lhs);


    TreeSet ths = new TreeSet<>();
    ths.add("Delhi");
    ths.add("Mumabai");
    ths.add("Noida");
    ths.add("Bengaluru");
    System.out.println(ths);



}
}