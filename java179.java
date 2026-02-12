import java.util.*;
public class java179 {
     public static void main(String args[]){
        Queue<Integer> q =new LinkedList<>();//array deque , check the difference btw queue and array queue
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
