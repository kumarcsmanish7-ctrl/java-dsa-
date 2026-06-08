import java.util.*;
public class java210 {
    static class Heap{
        ArrayList<Integer>arr = new ArrayList<>();
        public void add(int data){
            //add at last index
            arr.add(data);
            // arr.size()-1 last index = child x 
            int x = arr.size()-1;// child index
            int par = (x-1)/2;// parent index

            while(x>0 && arr.get(x)<arr.get(par)){// O(logn) // x>0 because root node doesn't try to compare with itself
                // swap
                int temp =arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par,temp);

                //we have to update the parent and child as they have changed 
                x = par ;
                par = (x-1)/2;

            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int min = i ; 
            if(left<arr.size()&& arr.get(min)>arr.get(left)){//left<arr.size() -- check for whether it is a leaf node or not 
                min = left;
            }
            if(right<arr.size()&& arr.get(min)>arr.get(right)){
                min = right;
            }
            if(i != min){
                int temp = arr.get(i);
                arr.set(i,arr.get(min));
                arr.set(min, temp);

                heapify(min); 
            }

        }

        public int remove(){
            int data = arr.get(0);
            //swap first and last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2 - delete  last
            arr.remove(arr.size()-1);

            //step 3 heapify 
            if(!arr.isEmpty()){
            heapify(0);
            }
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String args[]){
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(5);
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
