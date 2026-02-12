// import java.util.ArrayList;
// import java.util.Collections;
import java.util.*;

public class java151{
    public static void main (String args[]){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(1);//O(1)
        list.add(8);
        list.add(30);
        list.add(4);
        System.out.println(list);

        Collections.sort(list);//ascending

        System.out.println(list);

        //descending 
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);


        //comparator - fnx logic 


    }
    
}
 