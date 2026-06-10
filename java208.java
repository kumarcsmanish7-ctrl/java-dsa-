import java.util.PriorityQueue;
import java.util.*;
public class java208 {
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());// to get decending order
        //comparitors are interfaces 



//order is not fixed , priority matters
        pq.add(3);//O(logn)
        pq.add(1); 
        pq.add(7);
        pq.add(4);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());//O(1)
            pq.remove();//O(logn)
        }
    }
}
