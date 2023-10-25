class Linked{
    Node head;
    class Node{
        int data;
        Node next;

        Node(int val){
            data=val;
            next=null;
        }
    }

    void insert(int val){
        Node node=new Node(val);

        if(head==null){
            head=node;
        }else{
            Node n=head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=node;
        }
    }

    void fill(){
        for(int i=1;i<100000;i=i+2){
            insert(i);
        }
    }

    void show(){
        Node n=head;
        
        while(n.next!=null){
            System.out.print(" "+n.data);
            n=n.next;
        }
        System.out.print(" "+n.data+"\n");
    }

    Node midNode(Node start , Node last){ // this will return the middle node 
        if(start==null)
        return null;

        Node slow=start;
        Node fast=start.next;

        while(fast!=last){ // iterating the whole linked list
            fast=fast.next;

            if(fast!=last){
                slow=slow.next; // slow pointer will move one step forward
                fast=fast.next;// fast pointer will move two steps forward
            }
        }
        return slow;
    }

    int binary(int key){
       Node start=head;
       Node last=null;

       int pass=1;

       do{
        System.out.print("\n pass="+pass);
        Node mid=midNode(start,last);
        System.out.print(" midnode = "+mid.data);

        if(mid==null){
            return -1;
        }
        if(mid.data==key){
            System.out.println("\nfound"); // element is found
            return 1;
        }
        else if(mid.data>key){ // if key is smaller than the mid node then we will search for left
            last=mid;
        }
        else{
            start=mid.next;
        }

        pass++;
       }while(start!=last);
       
       System.out.println("\nNOT FOUND");
       return -1;

    }


}

public class j25_binaryLL {
    public static void main(String[] args) {
        Linked list=new Linked();
        list.fill();
        list.show();
        list.binary(0);
        
        

        
    }
}
