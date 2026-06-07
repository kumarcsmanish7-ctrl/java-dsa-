import java.util.PriorityQueue;
import java.util.*;
public class java209 {

    // to store objects , java208 we stored Integer
    //we have to define on which basis to compare so we are using 
    // implements comparable , comparable is the interface
    static class Student implements Comparable<Student>{
        //function overriding
        String name ; 
        int rank ; 

        // making constructor 
        public Student(String name , int rank){
            this.name = name ;
            this.rank = rank;
        }
        // we are using function from the Comparable , 
        // parent class have a function and child class is implementing it, it is overriding 
        //function overriding 
        //@O   -- captital O
        @Override
        public int compareTo(Student s2){
            return this.rank- s2.rank;
            // this is a object  
        }
    }


    public static void main(String args[]){
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student ("A",4));
        pq.add(new Student ("B",2));
        pq.add(new Student ("C",6));
        pq.add(new Student ("D",9));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }
    }
}
