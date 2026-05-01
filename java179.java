import java.util.*;
public class java179 {
     public static void main(String args[]){
        Queue<Integer> q =new LinkedList<>();//queue is not a class its a interface so we cant create object of queue but we can create object of linked list because linked list implements queue interface 
        //linked list is used because of interface opps//array deque , check the difference btw queue and array queue
        Queue<Integer> temp =new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
     }
    
}
