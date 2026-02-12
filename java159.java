public class java159 {
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
    public static void main(String args []){
        java159 ll = new java159();//linked list ll = new LinkedList
        ll.head = new Node(1);// 1 is stored in the 1st 
        ll.head.next = new Node(2);

        // we will make methods in the linked list , we don't write it in the main function 
        

    }
}
