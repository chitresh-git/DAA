class Linked {
   // DOUBLY LINKED LIST - this type of linked list has an extra pointer which points at previous node in linked list 
   
    Node head;

    class Node {
        Node prev;
        Node next;
        int data;

        Node(int val) {
            data = val;
            next=null;

        }
    }

    void show() {
        // System.out.println(head.data);
        Node n = head;
        while (n.next!= null) {
            System.out.print(" " + n.data);
            n = n.next;
        }
        Node revert=n;
        
        System.out.print( " "+n.data+"\n");

        while(revert!=null){ // this will traverse the linked list in reverse using the prev pointer
            System.out.print(" " + revert.data);
           revert =revert.prev;
        }
          System.out.print( "\n");


    }

  

    void fill() {
        for (int i = 0; i <= 10; i++) {
            inserAtEnd(i);
        }
        show();
    }

    void inserAtEnd(int data){
        Node node=new Node(data);

        if(head==null){
            head=node;
            node.prev=null; // first prev point at null
        }
        else{

          
            Node n=head;
            
            while(n.next!=null){
                
                n=n.next;
                
            }
            node.prev=n; // pointing the prev node at the previous node 
            n.next=node;
        }
       

    }

    void insertatstart(int data){
        Node node=new Node(data);

        node.prev=null;
        head.prev=node;
        node.next=head;
        head=node;

        show();

    }

    void inserAtind(int data,int ind){
        if(ind==0)
        insertatstart(data);
        else{

            Node node=new Node(data);
            
        Node n=head;

        for(int i=0;i<ind-1;i++){
            n=n.next;
        }
        
        node.prev=n;
        n.next.prev=node;
        node.next=n.next;
        n.next=node;
        
        show();
    }




    }


    void deleteFromEnd(){
        Node n=head;

        while(n.next.next!=null){
            n=n.next;
        }
        n.next=null;

        show();

    }

    void deleteFromStart(){
        
        head=head.next;
        head.prev=null;

        show();
    }

    void deletefromINd(int ind){
      Node n=head;
      for(int i=0;i<ind-1;i++){
        n=n.next;
      }

      n.next.next.prev=n;
      n.next=n.next.next;

      show();
    }

}

public class j33_doubly {
    public static void main(String[] args) {
        Linked list=new Linked();

        System.out.println("\ninsert at the end");
        list.fill();
        
        System.out.println("\ninsert at the start");
        list.insertatstart(90);
        System.out.println("\ninsert at the index");
        list.inserAtind(68, 2);
        
        System.out.println("\ndelete from the end");
        list.deleteFromEnd();
        System.out.println("\ndelete from the start");
        list.deleteFromStart();
        System.out.println("\n delete from the specific index");
        list.deletefromINd(2);

    }
}
