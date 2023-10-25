
class linked {
    Node head;
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data=data;
            next = null;
        }
        
    }
    
    void show() { // this will show all the nodes present in the linked list
        
        Node n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

    int findLength(){
        Node n=head;
        int count=1;
        while(n.next!=null){
            n=n.next;
            count++;
        }
        return count;
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
    
    void deleteFromStart() { // deleting statring node from the linked list 
        Node n = head;
        head=n.next; // deleting 
        

    }

    void deleteFromIndex(int ind){
        if(findLength()<1 || ind<0){
            System.out.println("linked list is empty or either index is wrong given ");
        }
        else if(ind>=findLength()){
            System.out.println("insertion can not be done , linked list has only "+findLength()+" nodes , insert index below size.");
        }
        else if(ind==0){ // ind 0 means starting node 

            deleteFromStart();
            
        }else{ // deleting the node from the given index 

            Node n=head;
            for(int i =0 ; i<ind-1;i++){
                n=n.next;
            }
            Node temp=n.next; 
            n.next=temp.next;// deleting 
        }

    }

    int deleteUsingElement(int val){
        Node n=head;
        if(n.data==val){ // if deleting element is present at the start 
            deleteFromStart();
            return 0;
        }

        Node high=n.next; // maintaining the forward node 

        while(high.next!=null){
           if(high.data==val){
                n.next=high.next; // deleting the node
                break;
            }
            high=high.next;
            n=n.next;
        }
        System.out.println("element not found");
        return 0;
    }

    void deleteFromEnd(){
        Node n=head;
        Node high=n.next; // high is a forward pointer which will point at n+1 node 

        while(high.next!=null){ // uisng high we can able to stop the loop before the last node is pointed by the n
            high=high.next;
            n=n.next;
        }
        n.next=null; // deleting 
    }
    
}
public class j23_deletionSingly {
    public static void main(String[] args) {
        
        linked l = new linked();
        l.create();
        
        System.out.println("length of linked list : "+l.findLength());
        // System.out.println("before deleting starting node:");
        // l.show();
        // System.out.println("after deleting starting node:");
        // l.deleteFromStart();
        // l.show();
        // l.deleteFromEnd();
        
        // System.out.println("before:");
        // l.show();
        // l.deleteFromIndex(3);
        // System.out.println("after:");
        // l.show();

        l.deleteUsingElement(100);
        l.show();
        System.out.println("length of linked list : "+l.findLength());
    }


}
