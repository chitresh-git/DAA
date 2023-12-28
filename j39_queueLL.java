// implementation of  queue using linked list 

class linked{
    Node  front , rear;
    // front pointer used for deletion, and its head of the linked list 
    // insertion will takes place from the rear pointer , and its always point to the last node of linked list

    int size=0;

    class Node{
       int data;
       Node next;

       Node(int val){
        data=val;
        next=null;
       }
    }

    boolean isempty(){
        if(front==null){
            System.out.println("queue is empty ");
            return true;
        }
        else
        return false;
    }

    boolean isfull(){
        Node n=new Node(0);
        if(n==null){
            System.out.println("queue is full");
            return true;
        }
        else{
            return false;
        }
    } 

    void enqueue(int val){  // insert the node at rear end 
        if(isfull())
        return ;
        else{
            Node n=new Node(val);
            size++;
            
            if(front==null){
                front=n; // the first node is always front 
                rear=n;  // and first insertion , the new node is also the rear as well as the front 
            }

            else{
                rear.next=n;
                rear=n;
            }

            System.out.println(rear.data+ " is inserted in the queue and size is ="+size);
            show();
        }
    }

    void dequeue(){ // remove the node at from the front 
        if(isempty())
        return;
        else{
            size--;
            System.out.println(front.data+" is removed from the queue and size is = "+size);
            front=front.next;
            show();
        }
    }

    void show(){
        if(isempty())
        return ;
        else{
            Node n=front;

            while(n!=null){
                System.out.print(n.data+" ");
                 n=n.next;
            }
            System.out.println("\n");
        }
    }
}
public class j39_queueLL {
    public static void main(String[] args) {
        linked l=new linked();
        l.isempty();
        l.isfull();
        l.enqueue(10);
        l.enqueue(13);
        l.enqueue(17);
        l.enqueue(172);
        l.enqueue(19);
        
        l.show();

        l.dequeue();
        l.dequeue();
        l.dequeue();
        l.dequeue();
    }
}
