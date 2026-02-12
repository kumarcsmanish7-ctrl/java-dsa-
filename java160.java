public class java160 {
    public static class Node{
        int data ; 
        Node next; 

        public Node (int data){ // constructor 
            this.data = data ; 
            this.next = null ; 

        }
    }
    public static Node head ; 
    public static Node tail;
    static int size ;


    public void addFirst(int data){
        size++;        
        //step 1 = create new node 
        Node newNode = new Node(data);//same syntax that we used to write the object
        if(head == null){
            head = tail = newNode;
            return ; 

        }
        //step 2 - newNode next  = head 
        newNode.next = head;// link  

        //step 3 - head = newNode 
        head = newNode; 


    }
    public static void addLast(int data){
        size++;
        Node newNode = new Node(data);
        if(head == null ){
            head = tail = newNode ;
            return ; 
        }
        tail.next = newNode ; 
        tail = newNode ;
    }

    
    public void print(){
        if(head == null ){
            System.out.println("LL is empty");
            return ;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp =temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx , int data){
        if(idx == 0){
            addFirst(data);
            return; 
        }
        Node newNode = new Node (data);
        size++;
        Node temp = head ; 
        int i = 0 ;

        while (i<idx -1){
            temp = temp.next; 
            i ++;
        }
        //i = idx -1 ; i.e temp ->prev
        newNode.next = temp.next; 
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size ==1){
            int val = head.data;
            head =tail = null ; 
            size = 0;
            return val;
        }
        int val = head.data; 
        head = head.next ; 
        size --;
        return val; 
    }
    public int removelast(){
        if(size == 0 ){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size ==1){
            int val = head.data;
            head = tail  = null ; 
            size = 0 ; 
            return val;

        }
        //prev: i = size -2; 
        Node prev = head ; 
        for(int i = 0 ; i<size-2; i++){
            prev = prev.next ;
        }
        int val = prev.next.data ; //tail.data 
        prev.next = null ;
        tail = prev ; 
        size -- ; 
        return val; 
    }
    //iterative search 
    public int itrSeach(int key){//key found //O(n) 
        Node temp = head; 
        int i = 0 ;
        while(temp != null){
            if(temp.data == key){
                return i ; 
            }
            temp = temp.next;
            i++;
        }
        //key not found 
        return -1; 
    }

    public int helper(Node head, int key){//O(n) = time complexity and space complexity = O(n)
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0; 
        }
        int idx = helper(head.next , key);
        if(idx == -1){
            return -1;
        }
        return idx +1; 

    }
    //recursive search
    public int recSearch(int key){
        return helper(head,key);

    }
    public void reverse(){//3 variables and 4 steps //O(n)
        Node prev = null;
        Node curr = tail =head; 
        Node next ; 

        while (curr!=null){
            next = curr.next ;
            curr.next = prev; 
            prev = curr ; 
            curr = next ;

        }
        head = prev;
    
    }

    public void deleteNthfromEnd(int n){
        //calculate size 
        int sz  =0 ; 
        Node temp = head ; 
        while(temp != null){
            temp = temp.next; 
            sz++;
        }
        if(n == sz){
            head = head.next; //removeFirst
            return ; 
        }

        //sz-n
        int i = 1;

        int iToFind = sz-n ; 
        Node prev = head ; 
        while(i<iToFind){
            prev = prev.next; 
            i++;
        }
        prev.next = prev.next.next ;
        return ;  

    }

    //slow fast approach 
    public Node findMid(Node head){ //helper function 
        Node slow = head ; 
        Node fast = head ; 

        while(fast!= null && fast.next!= null){
            slow = slow.next ; //+1 turtle
            fast = fast.next.next ;//+2 hare 
        }
        return slow ; //slow is my midNode 
    }
    public boolean checkPalindrome(){
        if(head == null || head.next== null){
            return true ;
        }
        //step 1 - find mid 
        Node midNode = findMid(head);


        //step2 - reverse 2nd half 
        Node prev = null;
        Node curr = midNode ;//initialization is midNode 
        Node next; 
        while (curr!= null ){
            next = curr.next ; 
            curr.next= prev; 
            prev = curr; 
            curr = next ; 

        }
        Node right = prev ; //right half head  
        Node left = head ; 
        
        //step 3 - check left half and right half 
        while(right != null){
            if(left.data != right.data){
                return false ;
            }
            left = left.next ;
            right = right.next ;
        }
        return true ;




    }


    public static void main(String args []){
        java160 ll = new java160();//linked list ll = new LinkedList
        ll.print();
        ll.addFirst(1);

       
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);

        ll.add(2,9);
        ll.print();
        System.out.println(ll.size);

        ll.removeFirst();
        ll.print();

        ll.removelast();
        ll.print();
        System.out.println(size);


        System.out.println(ll.itrSeach(3));
        System.out.println(ll.itrSeach(10));

        System.out.println(ll.recSearch(3));
        System.out.println(ll.recSearch(10));

        ll.reverse();
        ll.print();

        ll.deleteNthfromEnd(3);
        ll.print();


        System.out.println(ll.checkPalindrome());
    }
}
