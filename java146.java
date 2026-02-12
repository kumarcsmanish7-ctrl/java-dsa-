import java.util.ArrayList;

public class java146 {
    public static void main (String args[]){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(1);//O(1)
        list.add(2);
        list.add(3);
        list.add(4);


        list.add(1,9);// O(n)
        //index 1 pe 9 add kar rahe he 
        System.out.println(list);

        //get operation  O(1)
        int element = list.get(2);
        System.out.println(element);

        //remove  delete O(n)
        list.remove(2);
        System.out.println(list);

        //Set  O(n)
        list.set(2,10);
        System.out.println(list);

        //contains 
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

    }
    
}
 