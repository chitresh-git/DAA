class Linked {
    Node head;
// DOUBLY CIRCULAR LINKED LIST : - this type of list has the property of both LL circular and doubly linked list
    class Node {
        Node prev;
        Node next;
        int data;

        Node(int val) {
            data = val;

        }
    }

    void show() {

        Node n = head;
        while (n.next != head) {
            System.out.print(" " + n.data);
            n = n.next;
        }
        Node revert = n;

        System.out.print(" " + n.data + "\n");

        while (revert != head) { // this will traverse the linked list in reverse using the prev pointer
            System.out.print(" " + revert.data);
            revert = revert.prev;
        }
        System.out.print(" " + revert.data + " \n");
        System.out.println("_____________________________________________________________________________");

    }

    void fill() {
        for (int i = 0; i <= 10; i++) {
            inserAtEnd(i);
        }
        show();
    }

    void inserAtEnd(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            node.next = head; // pointing last node to head making it as cycle list
            node.prev = head; // mainting the prev node which points at the previous node making it as a
                              // doubly LL

        } else {
            Node n = head.prev; // this will return last node of the LL in doubly circular ll head's prev contains the last node

            // while (n.next != head) { so , there is no need of traversing , hence time complexity of inserting an node at the end will become O(1)
            //     n = n.next;
            // }

            node.prev = n; // setting up the prev and next pointer of the new Node
            node.next = head;

            n.next = node;
            head.prev = node; // pointing the head prev to the last node
        }

    }

    void insertAtStart(int data) {
        Node lastNode = head.prev; // accessing the last node
        Node node = new Node(data);

        node.next = head; // setting up the prev and next pointer of the new Node
        node.prev = lastNode;

        lastNode.next = node; // pointing the last node next to the new node (first node)
        head.prev = node;// pointing old head prev to the new node (which becomes new head)

        head = node;// making the new node as new head

        show();

    }

    void insertAtINd(int data, int ind) {
        Node node = new Node(data);
        Node n = head;
        for (int i = 0; i < ind - 1; i++) {
            n = n.next;
        }
        node.prev = n;
        node.next = n.next;
        n.next.prev = node;
        n.next = node;

        show();

    }

    void deleteFromEnd() {
        Node last = head.prev;

        head.prev = last.prev;
        last.prev.next = head;

        show();
    }

    void deleteFromStart() {
        Node last = head.prev;

        head.next.prev = last;// second node's prev will point to the last node
        last.next = head.next;// last node's next will point to the second node

        head = head.next;// making the second node as a new head

        show();
    }

    void deleteFromInd(int ind){
        Node n = head;
        for (int i = 0; i < ind - 1; i++) {
            n = n.next;
        }

        n.next.next.prev=n;
        n.next=n.next.next;

        show();

    }
}

public class j34_doublycycle {

    public static void main(String[] args) {
        Linked list = new Linked();
        System.out.println("\n\ninsertion at the end:-\n");
        list.fill();
        System.out.println("\n\ninsertion at the start:-\n");
        list.insertAtStart(90);
        System.out.println("\n\ninsertion at the specific index:-\n");
        list.insertAtINd(67, 2);

        System.out.println("\n\ndeletion from the end:-\n");
        list.deleteFromEnd();
        System.out.println("\n\ndeletion from the start:-\n");
        list.deleteFromStart();
        System.out.println("\n\ndeletion from the specific index:-\n");
        list.deleteFromInd(2);
    }
}
