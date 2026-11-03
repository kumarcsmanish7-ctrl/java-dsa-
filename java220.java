import java.util.*;// majority element
public class java220 {
    


    public static void main(String args[]){
        int arr[] = {1,3,2,5,1,3,1,5,1};

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num:arr){
            // if(hm.containsKey(num)){
            //     hm.put(num,hm.get(num)+1);
            // }
            // else{
            //     hm.put(num,1);
            // }
 
            //the above 4 lines can be done in this way also 
           //key is same in both
            hm.put(num,hm.getOrDefault(num,0)+1);

        }
        // Set<Integer> keySet = hm.keySet();
        // for(Integer key: keySet){//shortcut is shown below  
        for(Integer key:hm.keySet()){
            if(hm.get(key)>arr.length/3){
                System.out.println(key);
            }
        }


    }
}
