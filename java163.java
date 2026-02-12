import java.util.*;
public class java163{
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

    

    
    
    private Node getMid(Node head){
        Node slow = head ; 
        Node fast = head.next; 

        while(fast!= null && fast.next != null){
            slow = slow.next ; 
            fast = fast.next.next ;
        }
        return slow ; //mid node 

    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL ; 
        while (head != null && head2 !=null ){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next ; 
            }else{
                temp.next = head2 ; 
                head2 = head2.next ; 
                temp = temp.next ; 

            }

        }
        //for the rest elements 
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next; 
            temp = temp.next ; 

        }
        while(head2 != null){
            temp.next = head2 ; 
            head2 = head2.next ; 
            temp = temp.next ; 
        }
        return mergedLL.next ; //bcz its 1st element is dummy 
        
    }
    public Node mergeSort(Node head ){
        if(head ==null || head.next ==null){
            return head; 
        }


        //find mid 
        Node mid = getMid(head);

        // left and right MS
        Node rightHead = mid.next ;
        mid.next = null ;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft , newRight); 

    }

    public void zigzag(){
        //find mid 
        Node slow = head ; 
        Node fast = head.next ;
        while(fast!= null && fast.next !=null){
            slow =slow.next ;
            fast = fast.next.next;
        }
        Node mid =slow ; 

        //reverse 2nd half 
        Node curr = mid.next; 
        mid.next = null;
        Node prev = null ; 
        Node next ;
        while (curr!= null){
            next = curr.next ; 
            curr.next = prev ;
            prev = curr; 
            curr= next ;
        }

        //alt merge -- zig-zag merge 

        Node left = head ;
        Node right = prev; 
        Node nextL, nextR;

        while(left!=null && right !=null){
            nextL = left.next; 
            left.next = right ; 
            nextR = right.next ; 
            right.next = nextL; 

            left = nextL; 
            right = nextR; 

        }
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        //5->4->3->2-> 1

        ll.print();
        ll.zigzag();
        ll.print();



        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        //O(nlogn )
    }
}