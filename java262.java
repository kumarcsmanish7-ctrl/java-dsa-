public class java262 {
    public static int lcs(String str1,int n,String str2,int m){
        if(n==0 || m==0){
            return 0 ;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return lcs(str1,n-1,str2,m-1)+1;
        }
        else{
            return Math.max(lcs(str1,n-1,str2,m),lcs(str1,n,str2,m-1));
        }
    }
    public static void main(String args[]){
        String str1= "abcdge";
        String str2 = "abedg";//lcs ="sbdg" ; length =4
        int n = str1.length();
        int m= str2.length();
        System.out.print(lcs(str1,n,str2,m));

    }
}
