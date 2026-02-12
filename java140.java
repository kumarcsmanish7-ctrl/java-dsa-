public class java140 {
    public static void findPermutation ( String str, String ans){
        //base case 
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        
        //recurssion time complexity = O(n*n! )
        for(int i = 0 ; i<str.length (); i++){
            char curr = str.charAt(i);
            //"abcde" => "ab"+"de" = "abde" to remove c 
            String newstr = str.substring(0,i)+str.substring(i+1);//don't use same string 
            findPermutation(newstr,ans+curr);
        }
    }
    public static void main ( String args[]){
        String str = "abc";
        findPermutation(str,"");
    }
}
