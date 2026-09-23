import java.util.*;
public class java229 {
    public static void main(String args[]){//O(n)
        int arr[] = {10,2,-2,-20,10};
    int k = -10;

    HashMap<Integer,Integer> map = new HashMap<>();
    //sum,count
    map.put(0,1);// important 

    int sum =0;
    int ans = 0 ; 
    
    for(int j =0 ; j< arr.length;j++){
        sum+=arr[j];
        if(map.containsKey(sum - k)){
            ans+= map.get(sum-k);// increase the count in the map
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
    }
    System.out.println(ans);

    }

}
