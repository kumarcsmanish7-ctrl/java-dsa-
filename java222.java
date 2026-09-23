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
        

    }
    

}
