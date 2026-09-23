import java.util.*;
public class java227 {
    public static String getStart(HashMap<String,String> tickets){
        //Hashmap that stores in reverse
        HashMap<String,String> revMap = new HashMap<>();

        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key),key);// making key as val , val as key, reversing the map
        }

        // finding start 
        for(String key: tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null; // just to remove the syntax error , but there will be no cases that includes this case 

    }
    public static void main(String args[]){
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi","Goa");


        //finding starting point 
        String start = getStart(tickets);
        System.out.print(start);
        for(String key: tickets.keySet()){
            System.out.print("->"+ tickets.get(start));// we will get the "to" 
            start = tickets.get(start);// update the from 
        }
        System.out.println();
    }
}
