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
        for (int i =20; i>0; i = i - 2) {
            insert(i);
        }
    }

    void show(Node head) {
        Node n = head;

        while (n.next != null) {
            System.out.print(" " + n.data);
            n = n.next;
        }
        System.out.print(" " + n.data + "\n");
    }



    void sortedInsertion(int val){ // this will insert a node at correct position in already sorted LL so that the resultant LL will also be sorted

        Node node=new Node(val);

        Node current=Sorted;
        if(current==null || current.data>=val){ // special case for head node 
            node.next=Sorted;
            Sorted=node;
        }
        else{
            while(current.next!=null && current.next.data<val){ // traversing till the correct position
                current=current.next;
            }
            node.next=current.next; // insertion takes place 
            current.next=node;
        }

    }

    void insertSort(){ // applying insertion by inserting  each node one by one using sorted insertion technique
        Node n=head;
        while(n!=null){
            sortedInsertion(n.data); // inserting each node in sorted manner
            n=n.next;
        }

    }

}





public class j28_insertionSortLL {
    public static void main(String[] args) {
        
        
        Linked list=new Linked();
        list.fill();
        System.out.println("before insertion sort");
        list.show(list.head);
        System.out.println("after insertion sort : ");
        list.insertSort();
        list.show(list.Sorted);
    }
}
