public class java127 {
    public static int firstOcc(int arr[],int key, int i ) {
        if(i==arr.length){
            return -1;

        }
        if(arr[i]==key){
            return i ;

        }
        return firstOcc(arr, key, i+1);
    }
    public static void main (String args[]){
        int arr[] = {8,22,56,3,244,6,5};
        System.out.println(firstOcc(arr,5,0));
    }
}
