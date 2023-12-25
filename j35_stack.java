// stack- stack is linear data structure which user the lifo principle
// implementing the stack using the array

class stack{
    static  int size;
    
    int top;
    int a[];

    void initiate(int s){
        a=new int[s];
        size=s;
    }

    stack(){
        top=-1;
    }

    boolean isEmpty(){
        if(top<0){
            System.out.println("stack is empty\n");
            return true;
        }
        else
              return false;     
    }

    boolean isFull(){
        if(top>=size-1){
            System.out.println("stack is full\n");
            return true;
        }
        else
         return false;
    }

    int push(int data){
        if(isFull()){
            return 0;
        }
        else{
            a[++top]=data;
            System.out.println(data+" is pushed into the stack \n");
            return 1;
        }

    }

    int pop(){
        if(isEmpty()){
            return 0;
        }
        else{
            int poped=a[top];
            a[top--]=0;
            System.out.println(poped+" is poped out from the stack \n");
            return poped;

        }
    }

    int peek(){ // will return the element which is at top of the stack without deleting it 
        if(isEmpty())
        return 0;
        System.out.println(a[top]);
        return a[top];
    }

    void show(){
        if(isEmpty())
        return ;

        for(int i=top;i>=0;i--){
            System.out.print(" "+a[i]);
        }
        System.out.println(" \n");
    }

}

public class j35_stack{

    public static void main(String[] args) {
        
        stack s=new stack();
        s.initiate(10);
        s.isEmpty();
        s.isFull();
        s.push(12);
        s.push(134);
        s.push(12);
        s.push(67);

        s.show();
        s.pop();
        s.show();
        s.peek();
    }

}