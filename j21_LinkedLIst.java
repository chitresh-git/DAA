// LINKED LIST : linked list is collection of objects ,known as nodes . each node has data and next pointer 
// it is a linear data structure which stores the element at non contagious memory locations 

 class linklist{
    Node head;// head pointer points towards the start of the LL 

     class Node{ // node contains data for storing the data elements and next pointer which will hold the address of next node
        int data;
        Node next;
    }

     void insert(int data){
         Node node=new Node(); // creating a new node dynamically
         node.data=data; // storing the data 
         node.next=null; // pointing its next to the null 

         if(head==null){ // if head is null it means linked list is already empty 
            head=node;// then we will point head towards the newly created node 
         }
         else{// if linked list is not empty , then 
            Node n=head;
            while(n.next!=null){// we willl traverse till the last node of the LL 
                n=n.next;
            }
            n.next=node; // then we just simply add the newly node with last node of LL 
         }

    }

    void show(){ // traversing each node present in LL 
        Node n=head;
        do{
            System.out.println(n.data);
            System.out.println(n.next);
            n=n.next;

        }while(n.next!=null);
    }
}

public class j21_LinkedLIst {
    

    public static void main(String[] args) {
        linklist l =new linklist();

        l.insert(12);
        l.insert(13);
        l.insert(13);
        l.insert(13);
        l.show();

    }
}
