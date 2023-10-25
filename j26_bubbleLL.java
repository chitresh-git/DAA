class Linked {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    void insert(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    void fill() {
        for (int i = 8; i >= 0; i = i - 2) {
            insert(i);
        }
    }

    void show() {
        Node n = head;

        while (n.next != null) {
            System.out.print(" " + n.data);
            n = n.next;
        }
        System.out.print(" " + n.data + "\n");
    }

    void bubble() {
        Node current, forward, prev = null;
        // prev=null;
        int pass = 1;
        boolean swap=true;

        while(swap){

            System.out.println("pass=" + pass++);
            current = head;
            forward = head.next;
            swap = false;

            while ( current.next != prev && current.next != null) {
                if (current.data > forward.data) {
                    int temp = current.data;
                    current.data = forward.data;
                    forward.data = temp;
                    swap = true;

                }
                current = current.next;
                forward = forward.next;

                show();

            }
            prev = current;

        }

    }

}

public class j26_bubbleLL {

    public static void main(String[] args) {

        Linked list = new Linked();
        list.fill();
        list.show();
        list.bubble();
        System.out.println("sorted linked list : ");
        list.show();

    }
}
