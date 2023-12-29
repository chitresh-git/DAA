//  DOUBLE ENDED QUEUE 
// implementing DEqueue using array 
class queue{
    int rear, front , size,capacity;
    int a[];   // array 

    queue(int n){
        rear=-1;  // insertion will be performed from rear end 
        front=-1; // deletion will be performed from te front end 
        size=0;

        a=new int[n];
        capacity=n-1;
    }

    boolean isFull(){       // return true if queue is full 
        if(rear>=capacity){
            System.out.println("inertion cant be done from rear");
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

    void enqueueREAR(int n){      // perform insertion at rear end
        if(isFull())
        return;

        else{
            rear++;
            size++;

            a[rear]=n;
            System.out.println(n+" is added to the queue and size is ="+size);
        }

        if(rear==0) // increasing the front to 0 for the first insertion 
        front++;
    }
    void enqueueFRONT(int n){      // perform insertion in queue at front end
        if(front<=0 ){
            
            System.out.println("insertion from front is not possible");
            return;
        }

        else{
            size++;
            front--;
            a[front]=n;
            System.out.println(n+" is added to the queue and size is ="+size);
        }

    
    }

    void dequeueFRONT(){          // perform deletion at front end 
        if(isEmpty())
        return ;
        else{
            size--;
            int temp=a[front];
            System.out.println(temp+" element is removed from the queue and size is ="+size);
            front++;
        }
    }
    void dequeueREAR(){          // perform deletion at rear end
        if(rear<0 || rear<front){

            System.out.println(" deletion can not be performed from front ");
            return ;
        }
        else{
            size--;
            int temp=a[rear];
            System.out.println(temp+" element is removed from the queue and size is ="+size);
            rear--;
        }
    }

    void show(){
        if(isEmpty())
        return  ;

        for(int i=front;i<=rear;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println(" \n");
    }


}

public class j41_DEqueue {
    public static void main(String[] args) {
        queue l=new queue(5);

        l.isEmpty();
        
        l.enqueueREAR(12);
        l.enqueueREAR(12);
        l.enqueueREAR(15);
        l.enqueueREAR(16);

        l.enqueueFRONT(7);
         
        l.show();



        l.enqueueFRONT(56);
        l.enqueueFRONT(78);
  

        l.show();

        l.dequeueFRONT();
        l.dequeueFRONT();
        l.dequeueFRONT();

        l.show();

        l.dequeueREAR();
        l.dequeueREAR();
        l.dequeueREAR();
        l.dequeueREAR();
        l.dequeueREAR();
        
        l.show();

        l.enqueueREAR(23);
        l.enqueueREAR(26);
        l.enqueueREAR(83);
  
        l.enqueueFRONT(34);
        l.enqueueFRONT(36);

        l.show();

    }
}
