class Linked {
    Node head;
// this program will insert the new node in already sorted LL in such a way that new LL will also remains Sorted
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
        for (int i = 0; i<20; i = i + 2) {
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

    // void insertSort(){
    //     Node dummy=new Node(-1);

    //     Node current=head;
    //     while(current!=null){
    //         Node temp=current.next;
    //         Node prev=dummy;
    //         Node forward=dummy.next;

    //         while(forward!=null){
    //             if(forward.data>current.data){
    //                 break;
    //             }
    //             prev=forward;
    //             forward=forward.next;
    //         }
    //         current.next=prev.next;
    //         prev.next=current;
    //         current=temp;
    //     }

    // }

    void sortedInsertion(int val){ // this will insert a node at correct position in already sorted LL so that the resultant LL will also be sorted

        Node node=new Node(val);

        Node current=head;
        if(current==null || current.data>=val){ // special case for head node 
            node.next=head;
            head=node;
        }
        else{
            while(current.next!=null && current.next.data<val){ // traversing till the correct position
                current=current.next;
            }
            node.next=current.next; // insertion takes place 
            current.next=node;
        }

    }

}


public class j27_sortedInsertion {


    public static void main(String[] args) {
        Linked list=new Linked();
        list.fill();
        System.out.println("before insertion");
        list.show();
        System.out.println("after sorted insertion: ");
        list.sortedInsertion(-1);
        list.show();

    }
}
