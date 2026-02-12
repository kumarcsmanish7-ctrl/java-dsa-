public class java164 {
    public class Node {
        int data ;
        Node next ;
        Node prev; 

        public Node(int data){
            this.data = data ; 
            this.next = null ;
            this.prev = null ; 
        }
    }
    public static Node head ; 
    public static Node tail ; 
    public static int size ; 


    //addFirst
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null ){
            head = tail = newNode ; 
            return ;             
        }
        newNode.next = head ; 
        head.prev = newNode ;
        head = newNode ;
    }

    //print 
    public void print(){
        Node temp = head ; 
        while(temp != null){
            System.out.print(temp.data+ "<->");
            temp = temp.next ;
        }
        System.out.println("null");
    }

    //remove 
    public int removeFirst(){
        if(head == null){
            System.out.println("DLL is empty ");
            return Integer.MIN_VALUE ; //not returning a valid index 
        }
        if(size ==1){
            int val = head.data ; 
            head = tail = null; 
            size-- ; 
            return val; 

        }
        int val = head.data ; 
        head = head.next ;
        head.prev = null ; // this line will give error if size is 1 
        size--;
        return val; 
    }
    public void reverse (){
        Node curr = head ; 
        Node prev = null ; 
        Node next ; 
        while (curr!= null){
            next = curr.next ; 
            curr.next = prev ; 
            curr.next = next ;
            
            prev = curr ; 
            curr = prev ;
        }
        head = prev ; 
    }


    

    public static void main (String args []){
        //DoubleLL dll = new DoubleLL();   wrong 
        java164 dll = new java164();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.out.print(size);

        dll.removeFirst();
        dll.print();
        System.out.println(dll.size);


        dll.reverse();
        dll.print();
    }
}
