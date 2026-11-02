public class java276 {
    static int tree[];
    public static void init(int n){
        tree =new int[4*n];
    }
    public static int buildST(int arr[],int sti,int start,int end){
        if(start == end){
            tree[sti]=arr[start];
            return arr[start];
        }
        int mid =(start+end)/2;
        buildST(arr,2*sti+1,start,mid); //left subtree  
        buildST(arr,2*sti+2,mid+1,end);//right subtree
        tree[sti]=tree[2*sti+1]+tree[2*sti+2];
        return tree[sti];
    }
    public static int getsumUtil(int i,int si,int sj,int qi,int qj){
        if(qj<si ||qi>sj){//no overlap
            return 0;
        }
        else if(si>=qi && sj<=qj){//complete overlap
            return tree[i];
        }
        else{//partial overlap
            int mid = (si+sj)/2;
            return getsumUtil(2*i+1,si,mid,qi,qj)+getsumUtil(2*i+2,mid+1,sj,qi,qj);
        }
    }
    public static int getSum(int[] arr,int qi,int qj){
        int n = arr.length;
        return getsumUtil(0,0,n-1,qi,qj);


    }

    //O(logn)
    public static void updateUtil(int i, int si,int sj, int idx, int diff){
        if(idx>sj|| idx<si){//non overlapping
            return;
        }
        tree[i] +=diff;
        if(si!=sj){
            //non leaf
            int mid = (si+sj)/2;
            updateUtil(2*i+1,si,mid,idx,diff);//left
            updateUtil(2*i+2,mid+1,sj,idx,diff);//right
        }
    }
    public static void updateST(int[] arr, int idx, int newvalue){
        int n = arr.length;
        int diff = newvalue -arr[idx];
        arr[idx]= newvalue;
        updateUtil(0,0,n-1,idx,diff);

    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr,0,0,n-1);
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        System.out.println(getSum(arr,2,5));

        updateST(arr,2,2);
        System.out.println(getSum(arr,2,5));
        
    }
}
