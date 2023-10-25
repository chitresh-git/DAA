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
        for (int i = 20; i > 0; i = i - 2) {
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





void Selection(){
Node current=head;
while(current.next!=null){
    Node min=current;
    Node n=current.next;

    while(n!=null){
        if(min.data>n.data)
        {
            min=n;
        }
        n=n.next;
    }
    int temp=min.data;
    min.data=current.data;
    current.data=temp;

    current=current.next;
}
            

        }
    }



public class j29_selectionsortLL {
public static void main(String[] args) {
    Linked list=new Linked();
    list.fill();
    list.show(list.head);
    list.Selection();
    list.show(list.head);

}
}
