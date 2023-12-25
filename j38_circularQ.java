class circular {
    int a[];
    int front, rear, size;

    circular(int n) {
        a = new int[n + 1]; // if the size of queue is 4 then it can store only 3 elements there fore we
                            // increases the size by 1
        front = 0;
        rear = 0;
        size = n + 1;
    }

    boolean isfull() {
        if ((rear + 1) % size == front) {
            System.out.println("queue is full ");
            return true;
        } else
            return false;
    }

    boolean isempty() {
        if (front == rear) {
            System.out.println("queue is empty ");
            return true;
        } else
            return false;

    }

    void enqueue(int val) {
        if (isfull())
            return;
        else {
            rear = (rear + 1) % size;
            a[rear] = val;
            System.out.println(val + " element is inserted \n");

        }

    }

    void dequeue() {
        if (isempty())
            return;
        else {
            front = (front + 1) % size;
            int temp = a[front];
            System.out.println(temp + " element removed \n");

        }
    }

    void show() {
        if (isempty())
            return;
        else {
            System.out.println(front+" "+rear);
            if (front < rear) {
                for (int i = front + 1; i <= rear; i++) {
                    System.out.print(" " + a[i]);
                }
                System.out.println("\n");

            } else {
                for (int i = front + 1; i < size; i++) {
                    System.out.print(" " + a[i]);
                }
                for (int i = rear; i <=rear; i++) {
                    System.out.print(" " + a[i]);
                }
                System.out.println("\n");
            }
        }
    }
}

public class j38_circularQ {
    public static void main(String[] args) {
        circular c = new circular(4);

        c.isempty();

        c.enqueue(72);
        c.enqueue(923);
        c.enqueue(12);
        c.enqueue(12);
        c.enqueue(122);

        c.show();

        c.dequeue();
        c.enqueue(152);
        c.enqueue(34);

        c.show();

        c.dequeue();
        c.dequeue();

        c.show();

    }
}
