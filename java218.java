import java.util.*;// implementation of hashmap
public class java218 {
    static class HashMap<K,V>{
        public class Node {
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;

            }
        }
        private int n; //n
        private int N;

        //linked list of nodes 
        private LinkedList<Node> buckets[]; // N = buckets.length
        @SuppressWarnings("unchecked")//we are using this because we are using the linked list without its type below 
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i =0;i<4; i++){
                this.buckets[i] = new LinkedList<>();// here no type is specified so suppress warning is used 
            }
        }//this above part is given 
        // now we have to write the below part 




        private int hashFunction(K key){// K type key
            int hc = key.hashCode();// this function is used to change the form
            // hashCode() this function is inbuilt 
            return Math.abs(hc)% N;  // we can get the negetive values as well

        }
        private int searchInLinkedList(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int dataindex = 0 ;
            for(int i = 0 ;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key== key ){
                    return dataindex;
                }
                dataindex++;
            }
            return -1;
        }


        @SuppressWarnings("unchecked")
        private void rehash(){//first store current data 
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N= N*2;
            //making empty nodes  -- initialization 
            for(int i =0;i<buckets.length; i++){
                buckets[i] = new LinkedList<>();

            }
            // nodes -> add in bucket
            for(int i = 0 ; i< oldBuck.length;i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j = 0 ;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }

        }


        public void put(K key, V value){//O(lamda) -- lamda is a constant 
            int bucketindex = hashFunction(key);//we need value between 0 to 3 so we take modulo with 4 or size 
            int dataindex = searchInLinkedList(key, bucketindex);//valid index if exits , if nothing exists get -1 
            if(dataindex!=-1){
                Node node = buckets[bucketindex].get(dataindex);
                node.value = value;

            }
            else{
                buckets[bucketindex].add(new Node(key,value));
                n++;
            }
        

            double lamda = (double)n/N;

            if(lamda>2.0){
                rehash();
            }
        }


        public boolean containsKey(K key){  // O(1)
            //same  thing in put function copied and pasted
            int bucketindex = hashFunction(key);//we need value between 0 to 3 so we take modulo with 4 or size 
            int dataindex = searchInLinkedList(key, bucketindex);//valid index if exits , if nothing exists get -1 
            if(dataindex!=-1){// changed here 
                return true;

            }
            else{
                return false ;
            }
        }



        public V remove(K key){  //O(1)
            int bucketindex = hashFunction(key);//we need value between 0 to 3 so we take modulo with 4 or size 
            int dataindex = searchInLinkedList(key, bucketindex);//valid index if exits , if nothing exists get -1 
            if(dataindex!=-1){
                Node node = buckets[bucketindex].remove(dataindex);//-- replaced get with remove here
                n--; // very important // we have to reduce the size of the nodes 
                return node.value;

            }
            else{// if no node exists return null
                return null;
            }
        }
        public V get(K key){ //O(1)
            int bucketindex = hashFunction(key);//we need value between 0 to 3 so we take modulo with 4 or size 
            int dataindex = searchInLinkedList(key, bucketindex);//valid index if exits , if nothing exists get -1 
            if(dataindex!=-1){
                Node node = buckets[bucketindex].get(dataindex);
                return node.value ;

            }
            else{// if we get -1 ==means node not found 
                return null;
            }

        }



        public ArrayList<K> keySet(){ // we have to return a arraylist of the keys 
            ArrayList<K> keys = new ArrayList<>();// keys are of K type so we are using ArrayList<K-- it can be Integer, String > 
            for(int i = 0 ; i<buckets.length;i++){
                LinkedList<Node> ll =buckets[i];
                for(Node node: ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n ==0;
        }

    }
    public static void main(String args[]){
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("INDIA", 100);
        hm.put("INDO", 10);
        hm.put("Us", 11);



        ArrayList<String> keys = hm.keySet();
        for(String key: keys){
            System.out.println(key);
        }

        System.out.println(hm.get("INDIA"));
        System.out.println(hm.remove("INDIA"));
        System.out.println(hm.get("INDIA"));
    }
}
