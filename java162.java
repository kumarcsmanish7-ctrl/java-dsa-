import java.util.LinkedList ; // or we can use java.util.*;
public class java162 {//the functions will be optimized 
    public static void main(String args[]){
        //create - we can only use class that is Integer , Float , Character , we cannot use int , float , boolean 
        LinkedList<Integer> ll = new LinkedList<>(); // same like array list

        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        //0-> 1-> 2->
        System.out.println(ll);
        //remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);

    }
    
}
