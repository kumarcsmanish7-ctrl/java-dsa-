import java.util.*;
public class java221 {
    public static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i =0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch)!= null){
                if(map.get(ch)==1){// if the frequency is 1 remove the "key"
                    map.remove(ch);
                }
                else{
                    map.put(ch,map.get(ch)-1);
                    //decrease the frequency of the key by 1
                }
            }
            else{
                return false;
                //means t has some value that doesnot exist in s
            }
        }
        return map.isEmpty();
    }   
    
    public static void main(String args[]){
        String s = "race";
        String t = "care";

        System.out.println(isAnagram(s,t));

    }
}
