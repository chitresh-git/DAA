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
        for(int i=1;i<20;i=i+2){
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

    int linearSearch(int key){
        Node n=head;
        while(n.next!=null){
            if(n.data==key)
            return 1;

            n=n.next;

        }
        if(n.data==key)
        return 1;
        return -1;
    }
    

    int enhancedLinearSearch(int key){
        Node n=head;
        while(n.next.next!=null){  // this type of searching takes half number of passes as it checks two pointers in each passes
            if(n.data==key || n.next.data==key){

                System.out.println("found");
                return 1;
            }

            n=n.next.next;

        }
        if(n.data==key || n.next.data==key){
               System.out.println("found");
            return 1;
        }
        System.out.println("not found");
        return -1;
    }
}

public class j24_linearsearchLL{


    public static void main(String[] args) {
        Linked list=new Linked();
        list.fill();
        list.show();
        int key=19;
        if(list.linearSearch(key)==1){
            System.out.println("found");
        }
        else{
            System.out.println("not found");
        }

        list.enhancedLinearSearch(19);
    }
}