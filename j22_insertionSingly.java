
class linklist {
    Node head; // head which is reference for the starting node of the linked list

    class Node { // Node class which has two data memmbers , data which will store the element
                 // and next pointer which will store the address of next node
        int data;
        Node next;

        Node(int ele) { // constructor which will get invoked as soon as Node object is created
            data = ele;
            next = null;

        }
    }

    void create() { // this will create linked list
        for (int i = 10; i > 0; i -= 2) {

            inserAtEnd(i);
        }
    }

    void inserAtEnd(int data) { // this will insert node at the end of linked list
        Node node = new Node(data);
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

    void inserAtStart(int data) { // this will insert node at begining of linked list

        create();
        // show();

        Node node = new Node(data);
        // Node n=head;
        node.next = head;
        head = node;
        show();

    }

    void insertAtIndex(int data, int ind) { // this will insert the node at the given index

        create(); // first creating a list
        System.out.println("before inserting at index:");
        show();
        Node node = new Node(data);
        Node n = head;

        for (int i = 0; i < ind - 1; i++) {
            // System.out.println(n.data);
            n = n.next;

        }
        node.next = n.next;
        n.next = node;

    }

    void show() { // this will show all the nodes present in the linked list
        Node n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }
}

public class j22_insertionSingly {

    public static void main(String[] args) {
        linklist list = new linklist();
        // list.inserAtStart(12);
        // list.inserAtStart(14);
        // list.inserAtStart(18);
        // list.show();

        // list.inserAtStart(89);

        list.insertAtIndex(99, 2);
        System.out.println("after inserting at index:");
        list.show();
    }

}