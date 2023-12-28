// implementation of cicular queue using linked list 

class linked {
    Node front, rear;
    // front pointer used for deletion, and its head of the linked list
    // insertion will takes place from the rear pointer , and its always point to
    // the last node of linked list

    int size = 0;

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    boolean isempty() {
        if (front == null ) {
            System.out.println("queue is empty ");
            return true;
        } else
            return false;
    }

    boolean isfull() {
        Node n = new Node(-1);
        if (n == null) {
            System.out.println("queue is full");
            return true;
        } else {
            return false;
        }
    }

    void enqueue(int val) { // insert the node at rear end
        if (isfull())
            return;
        else {
            Node n = new Node(val);
            size++;

            if (front == null) {
                front = n; // making new node as front
                rear = n;
                rear.next = front; // connecting it new node next with front making it circular queue
            }

            else {
                rear.next = n; // connecting last node with new node
                rear = n;
                rear.next = front; // and then connecting rear next with front thus completing the circular queue

            }

            System.out.println(rear.data + " is inserted in the queue and size is =" + size);
            show();
        }
    }

    void dequeue() { // remove the node at from the front
        if (isempty())
            return;
        else {
            size--;
            System.out.println(front.data + " is removed from the queue and size is = " + size);

            if(front.next==front){ 
                // while dequeing , when front reaches to the last node (rear) we will reset both of them to the null
                rear=null;
                front=null;

            }
            else{
                front = front.next; // shifting front one step ahead
                rear.next = front; // updating the next of rear

            }

            show();
        }
    }

    void show() {
        if (isempty())
            return;
        else {
            Node n = front;
            System.out.print("queue= ");
            while (n != rear) {
                System.out.print(n.data + " ");
                n = n.next;
            }
            System.out.println(n.data+"\n");
        }
    }
}

public class j140_circularQueueLL {
    public static void main(String[] args) {
        linked l = new linked();
        l.isempty();
        l.isfull();
        l.enqueue(10);
        l.enqueue(13);
        l.enqueue(17);
        l.enqueue(172);
        l.enqueue(19);

        l.show();
        System.out.println(" the next of rear node is ="+ l.rear.next.data); // this will print front node , because in circular queue the next of rear
                                              // is front node 

        l.dequeue();
        l.dequeue();
        l.dequeue();
        l.dequeue();
        l.dequeue();
 
    }
}
