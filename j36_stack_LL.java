// implimenting the stack using linekd list 

class Linked {
    Node top;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    int isEmpty() {
        if (top == null) {
            System.out.println("stack is empty");
            return 1;
        } else
            return 0;
    }

    int isFull() {
        Node node = new Node(-1);  // stack gets full when there is no space remain in our machine 
        if(node == null){
            System.out.println("stack is overflow");
            return 1;
        }

        else
            return 0;
    }

    void push(int data) {
        if (isFull() == 1)
            return;
        else {
            Node node = new Node(data);
            node.next = top;
            top = node;
            System.out.println(top.data + " is pushed into the stack");

        }
    }

    void pop() {
        if (isEmpty() == 1)
            return;
        else {
            System.out.println(top.data + " is poped out from the stack");
            top = top.next;
        }
    }

    int peek() {
        if(isEmpty()==1)
        return 0;
        System.out.println(top.data + " is at peek in the stack");
        return top.data;
    }

    void show() {
        Node n = top;
        while (n!= null) {
            System.out.print(" " + n.data);
            n=n.next;
        }
        System.out.println(" ");
    }
}

public class j36_stack_LL {
    public static void main(String[] args) {
        Linked s = new Linked();
        s.isEmpty();
        s.push(0);
        s.push(10);
        s.push(30);
        s.push(6);

        s.show();
        s.pop();
        s.show();
        s.peek();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }
}