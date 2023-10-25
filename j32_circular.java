class Linked {
    // CIRCULAR LINKED LIST :- in this type of list list last node is pointing to the head of the linked list
    Node head;

    class Node {
        Node next;
        int data;

        Node(int val) {
            data = val;

        }
    }

    void show() {
        // System.out.println(head.data);
        Node n = head;
        while (n.next != head) {
            System.out.print(" " + n.data);
            n = n.next;
        }
        System.out.print(" " + n.data + "\n");

    }

    void insert(int data) { // at end
        Node node = new Node(data);

        if (head == null) {
            head = node;
            node.next = head;// pointing the last node's next to the head making it circular linked list;

        } else {
            Node n = head;

            while (n.next != head) {
                n = n.next;
            }
            n.next = node;
            node.next = head;// pointing the last node's next to the head making it circular linked list;

        }

    }

    void fill() {
        for (int i = 0; i <= 20; i++) {
            insert(i);
        }
    }

    void inserAtEnd(Node head, int data) {
        Node n = head;
        while (n.next != head) {
            n = n.next;
        }
        Node node = new Node(data);
        n.next = node;
        node.next = head;

    }

    void insertAtStart(int data) {

        Node node = new Node(data);
        Node n = head;

        while (n.next != head) { // traversing till last node for inserting at the start of linked list 
            n = n.next;
        }
        n.next = node; // pointing last node's next to new node
        node.next = head; // pointing new node next to the current head
        head = node; // making new node as new head

    }

    void insertBetween(Node head, int data, int ind) {
        if (ind == 0)
            insertAtStart(data);
        else{{

            Node node = new Node(data);
            Node n = head;
            int count = 1;
            while (count < ind) {
                n = n.next;
                count++;
            }
            node.next = n.next;
            n.next = node;
        }}

    }

    void deleteFromEnd() {
        Node n = head;
        
        while (n.next.next != head) {
            n = n.next;
        }
        n.next=head;

        show();
        

    }

    void deleteFromStart(){
        Node n=head;
           while (n.next!= head) { // to delete from the start we have to traverse till the end of LL 
            n = n.next;
           }
           n.next=head.next; // pointing last node's next to the second node
           
           head=n.next;   // making the second node as the new head
           show();

      
    }

    void deleFromIndex(int ind){
        if(ind==0)
        deleteFromStart();
        else{

            
            Node n=head;
            int count=1;
            while(count<ind){
                n=n.next;
                count++;
            }
            n.next=n.next.next;
            
            show();
        }
    }
}

public class j32_circular {
    public static void main(String[] args) {
        Linked list = new Linked();
        list.fill();
        list.show();
        list.inserAtEnd(list.head, 99);
        list.show();
        list.insertAtStart(89);
        list.show();
        list.insertBetween(list.head, 75, 1);
        list.show();

        list.deleteFromEnd();
        System.out.println("delete from start:");
        list.deleteFromStart();
        list.deleFromIndex(21);
    }
}
