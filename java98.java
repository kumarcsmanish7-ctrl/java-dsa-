public class java98 {
    public static int SetIthBit(int n , int i ){
        int bitMask =1<<i;
        return n |bitMask;
    }
    public static int ClearIthBit(int n , int i ){
        int bitMask =~(1<<i);
    return n & bitMask;
    }

    public static int updateIthBit(int n , int i , int newBit){
        //approach 1

        // if(newBit ==0){
        //     return ClearIthBit(n,i);
        // }
        // else{
        //     return SetIthBit(n,i);
        // }


        // approach 2 , approach 1 and 2 have same time complexity
        n = ClearIthBit(n,i);
        int BitMask = newBit <<i;
        return n|BitMask;
    }

    public static void main (String args[]){
        System.out.println(updateIthBit(10,2,1));
    }
    
}
