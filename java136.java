public class java136 {
    public static void printarr (int arr[]){
        for(int i=0; i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
}
    //important
        public static int partition(int arr, int si,int ei){
            int pivot = arr[ei];
            int i = si-1;//to make place for elements smaller than pivot

            for(int j= si ;j<ei;j++){
                if(arr[j]<= pivot){
                    //we have to make space 

                    i++;
                    //swap
                    int temp =arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }

            }
            //making to bring pivot at the correct place 
            i++;
            int temp = pivot;
            arr[ei]=arr[i];//wrong pivot = arr[i] bcz we have to change in the array 
            //here it is call by value , it does not change in the array 

            //call by values are indirectly implemeted in java in arrays 


            arr[i]=temp;
            return i ; //pivots real index

    }
    public static void quickSort(int arr[], int si ,int ei){
        if(si>=ei){
            return;
        }
        
        
        //last element 
        int pIdx = partition(arr, si ,ei);//pIdx = partition index
        quickSort(arr, si, pIdx-1);//left 
        quickSort(arr, pIdx+1 , ei);//right
    }


        
   
    
    
    public static void main(String args[]){
        int arr[]= {6,3,9,8,2,5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);

    }
    
}
