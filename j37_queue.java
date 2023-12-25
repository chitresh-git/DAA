// QUEUE 
// implementing queue using array 
class queue{
    int rear, front , size;
    int a[];   // array 

    queue(int n){
        rear=-1;  // insertion will be performed from rear end 
        front=-1; // deletion will be performed from te front end 
        a=new int[n];
        size=n-1;
    }

    boolean isFull(){       // return true if queue is full 
        if(rear>=size){
            System.out.println("queue is full");
            return true;
        }
        else 
        return false;
    }

    boolean isEmpty(){       // return true if queue is empty 
        if(front<0 || front>rear){
            System.out.println("queue is empty");
            return true;
        }
        else
        return false;
    }

    void enqueue(int n){      // perform insertion in queue 
        if(isFull())
        return;

        else{
            rear++;
            a[rear]=n;
            System.out.println(n+" is added to the queue");
        }

        if(rear==0) // increasing the front to 0 for the first insertion 
        front++;
    }

    void dequeue(){          // perform deletion 
        if(isEmpty())
        return ;
        else{
            int temp=a[front];
            System.out.println(temp+" element is removed from the queue");
            front++;
        }
    }


}

public class j37_queue {
    public static void main(String[] args) {
        int capacity=3;
        queue d=new queue(capacity);
        
        d.isEmpty();

        d.enqueue(2);
        d.enqueue(2);
        d.enqueue(2);
        d.enqueue(2);

        d.dequeue();
        d.dequeue();
        d.dequeue();
        d.dequeue();

    }
}
