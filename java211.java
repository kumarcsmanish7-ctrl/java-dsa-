import java.util.*;
public class java211 {
    public static void swap(int a ,int b){
        int temp = a; 
        a=b;
        b= temp;
    }

    public static void heapify(int arr[] , int i,int size){
        int left  =2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left<size && arr[left]>arr[maxIdx]){
            maxIdx = left;
        }
        if(right<size && arr[right]>arr[maxIdx]){
            maxIdx = right;
        }
        if(maxIdx !=i){
            swap(arr[maxIdx],arr[i]);
            heapify(arr,maxIdx, size);
        }
    }
    public static void heapSort(int arr[]){//O(nlogn)
        // step 1 - build maxHeap 
        int n = arr.length;
        for(int i = n/2;i>=0;i--){
            //O(nlogn)
            heapify(arr, i,n);// for index i and size n 
        }

        // step 2 - push largest at end 
        for(int i = n-1; i>0;i--){
            //O(nlogn)
            // swap( largest-first , with last index)
            swap(arr[0],arr[i]);

            heapify(arr, 0,i);
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,4,5,3};
        heapSort(arr);
        // print 
        for(int i=0;i<arr.length;i++ ){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
}
