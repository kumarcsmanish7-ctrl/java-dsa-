import java.util.*;
public class java189 {
    public static void main (String args[]){
        int val[] ={60,100,120};
        int weight[]={10,20,30};
        int w=50;
        double ratio[][]= new double[val.length][2];
        //0th col => ixs; 1st col => ratio
        for(int i =0;i<val.length;i++){
            ratio[i][0]=1;
            ratio[i][1]=val[i]/(double)weight[i];
        } 
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
        //ascending order 
        //we need decending order sorting 
        int capacity = w;
        int finalval=0;

        for(int i = ratio.length-1;i>=0;i--){
            int index = (int)ratio[i][0];
            if(capacity>=weight[index]){//include full item
                finalval += val[index];
                capacity -= weight[index];
            }
            else{
                //include fractional item
                finalval+=(ratio[i][1]*capacity);//important
                capacity =0;
                break;
            }
        }
        System.out.println("final ans "+ finalval);
    }
    
}
