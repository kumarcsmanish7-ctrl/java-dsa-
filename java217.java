import java.util.*;
public class java217{
    public static void main(String args[]){
        HashMap<String , Integer> map = new HashMap<>();
        map.put("India",100);
        map.put("China",150);
        map.put("US", 50);


        //iterate 
        Set<String> keys = map.keySet();
        System.out.println(keys);

        for( String k : keys){
            System.out.println("key="+k+",value ="+map.get(k));
        }
    }
}