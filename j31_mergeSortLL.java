// merge sorted using recursion 

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

    Node mergeLL(Node a, Node b) {

        if (a == null)
        return b;
        if (b == null)
        return a;
        
        Node merged=null;


        if(a.data<=b.data){
            merged=a;
            merged.next=mergeLL(a.next, b);
        }
        else{
            merged=b;
            merged.next=mergeLL(a, b.next);
        }
        return merged;

    }

    Node midNode(Node head) {
        if(head==null)
        return head;

        System.out.println(head.data);
       Node slow = head, fast = head;
 
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        

        // System.out.println(slow.data);
        return slow;
    }

    Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = midNode(head);
        Node midnext = mid.next;

        // System.out.println(mid.data);
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(midnext);

        Node result = mergeLL(left, right);

        // show(result);

        return result;

    }
}

public class j31_mergeSortLL {
    public static void main(String[] args) {

        Linked list = new Linked();
        list.fill();
        // list.show(list.head);
        list.show(list.head);
list.head=list.mergeSort(list.head);
        list.show(list.head);

    }
}
