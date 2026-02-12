public class java128 {
    public static int lastOcc(int arr[],int key, int i ) {
        if(i==arr.length){
            return -1;
        }
        int isFound = lastOcc(arr, key , i+1);

        if(isFound == -1 && arr[i]==key){
            return i;
        }
        return isFound;

        }

    
    public static void main (String args[]){
        int arr[] = {8,22,56,3,244,6,5};
        System.out.println(lastOcc(arr,5,0));
    }
}
