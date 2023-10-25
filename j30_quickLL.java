
class Linked {
    Node head;
    Node Sorted;

    // performing insertion sorting
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
        insert(0);
        for (int i = 20; i > 0; i = i - 2) {
            insert(i);
        }
        insert(22);
    }

    void show(Node head) {
        Node n = head;

        while (n.next != null) {
            System.out.print(" " + n.data);
            n = n.next;
        }
        System.out.print(" " + n.data + "\n");
    }

    Node partition(Node start, Node end) {
        if (start == null || start == end || end == null) {
            return start;
        }
        Node prev = start;
        Node current = start;
        int pivot = end.data;

        while (start != end) {
            if (start.data < pivot) {
                prev = current;

                int temp = current.data;
                current.data = start.data;
                start.data = temp;

                current = current.next;

            }
            start = start.next;
        }
        // int temp=pivot;
        end.data = current.data;
        current.data = pivot;

        return prev;

    }

    void quick(Node start, Node end) {
        // System.out.println(end.data);

        if (start == null || start == end || start == end.next) {
            return;
        } else {
            Node prevPartNode = partition(start, end);
            quick(start, prevPartNode);

            // if(prevPartNode!=null && prevPartNode==start)
            quick(prevPartNode.next, end);

            // else if(prevPartNode!=null && prevPartNode.next!=null)
            // quick(prevPartNode.next.next, end);

        }

    }

    void run() {
        Node n = head;
        while (n.next != null) {
            n = n.next;

        }
        quick(head, n);
    }
}

public class j30_quickLL {
    public static void main(String[] args) {

        Linked list = new Linked();
        list.fill();
        list.show(list.head);
        list.run();
        list.show(list.head);

    }

}
