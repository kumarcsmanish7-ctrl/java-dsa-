public class java54 {
    public static void hollow_rectangle(int totRows ,int totCol){
        //outer loop 
        for (int i=1; i<=totRows ; i++){
            //inner colums 
            for(int j =1; j<=totCol;j++){
                //cell = (i,j)
                if(i==1|| i ==totRows || j==1|| j==totCol){
                    //boundary cells
                    System.out.print("*");

                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        }
        public static void main(String args[]){
            hollow_rectangle(4,5);
        }
    }
