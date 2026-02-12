import java.util.*;
public class java172 {
    public static void main(String[] args) {
        int arr[] ={6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];
        for(int i = arr.length -1 ;i>=0; i--){
            //1 while 
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){//important index ko store karna he number nahi stack mai
                s.pop();
            }
            //2 if-else
            if(s.isEmpty()){
                nextGreater[i] = -1;
        } 
        else{
            nextGreater[i] = arr[s.peek()];//not s.peek()
        }
        //3 push in s 
        s.push(i);


    }
    for(    int i =0;i<nextGreater.length;i++){
        System.out.print(nextGreater[i]+" ");   
    }
    System.out.println();
    }

    //forms of this question 
    //next greater to right (explained above)
    //nexxt greater to left ( loop from 0 to n-1)
    //next smaller to right( arr[s.peek()]>=arr[i] in while)
    //next smaller to left ( loop from 0 to n-1 and arr[s.peek()]>=arr[i] in while)
}