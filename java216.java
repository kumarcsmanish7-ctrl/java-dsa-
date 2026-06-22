import java.util.*;
public class java216 {
    public static void main (String args[]){
        //create 
        HashMap<String,Integer> hm = new HashMap<>();
        
        //insert
        hm.put("India",100);
        hm.put("china",150);
        hm.put("US",50);

        System.out.println(hm);

        //get - O(1)
        int population = hm.get("India");
        System.out.println(population);

        System.out.println(hm.get("indonasia"));

        //containskey-O(1)
        System.out.println(hm.containsKey("India"));//true
        System.out.println(hm.containsKey("Indonasia"));//false

        //remove 
        System.out.println(hm.remove("china"));
        System.out.println(hm);
    }
}
