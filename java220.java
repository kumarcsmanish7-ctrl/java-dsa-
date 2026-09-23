import java.util.*;// majority element
public class java220 {
    


    public static void main(String args[]){
        int arr[] = {1,3,2,5,1,3,1,5,1};

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num:arr){
            if(hm.containsKey(num)){
                hm.put(num,hm.get(num)+1);
            }
            else{
                hm.put(num,1);
            }

        }
        Set<Integer> keySet = hm.keySet();
        for(Integer key: keySet){
            if(hm.get(key)>arr.length/3){
                System.out.println(key);
            }
        }


    }
}
