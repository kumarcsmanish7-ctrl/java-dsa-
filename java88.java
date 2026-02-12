public class java88 {
    public static String Substring(String str,int si , int ei){
        String substr = "";
        for(int i =0;i<ei;i++){
           substr +=str.charAt(i);

        }
        return substr;

    }
    public static void main(String args[]){
        //substring 
        String str = "HelloWorld";
        System.out.println(Substring(str,0,5));//Hello


        //already existing substring function in java
        System.out.println(str.substring(0,5));
    }
    
}
