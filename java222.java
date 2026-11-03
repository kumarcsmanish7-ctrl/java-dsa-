import java.util.*;
public class java222 {
    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(14);
        System.out.println(set);

        if(set.contains(2)){
            System.out.println("set contains");
        }
        set.remove(2);
        if(set.contains(2)){
            System.out.println("set contains");
        }
        //set.size()
        System.out.println(set.size());

        //set.clear() -- whose set becomes clear or empty
        set.clear();
        System.out.println(set.size());

        //set.is empty
        System.out.println(set.isEmpty());

        

    }
    

}
