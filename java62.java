public class java62 {
    public static int linearSearch(int numbers[], int key ){
        for(int i =0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;//meaning our key does not exist     
    }
    public static void main(String args[]){
        int numbers[]={2,55,66,77};
        //string meny[]={"dosa","chole bhatore", "samosa"};dd
        int key = 55;
        int index = linearSearch(numbers,key);
        if(index==-1){
            System.out.println("NOT found ");
        }
        else{
            System.out.println("Found at index: "+ index);
        }

        
    }
}
