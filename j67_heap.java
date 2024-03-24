import java.util.Arrays;
// heap - // for 1 indexed array 

public class j67_heap {
    
    static int capacity=100;
    static int size=0;  // we will use 1 index system 

    static boolean isFull(){
        return (size==capacity-1) ? true: false;     
    }
    static boolean isEmpty(){
        return (size<0) ? true: false; 
    }

    static void swap(int b , int c, int a[]){
        int temp=a[b];
        a[b]=a[c];
        a[c]=temp;
    }

    static void insert(int val , int a[]){
        if(isFull()){
            System.out.println("heap is full");
            return ;
        }

        size++;
        a[size]=val;
        
        int i=size;
        int parent;

        while (i>1) {
            parent=i/2;

            if(a[parent]<a[i]){
                swap(parent,i,a);
                i=parent;
            }
            else
            return ;
        }
    }

    static void delete(int a[]){
        if(isEmpty()){
            System.out.println("heap is empty");
            return;
        }
        a[1]=a[size];
        size--;

        int i=1;

        while(i<size){
            int left=i*2;
            int right=i*2+1;

            if(left<size && a[i]< a[left]){
                swap(i, left, a);
                i=left;

            }

            else if(right<size && a[i]< a[right]){
                swap(i, right, a);
                i=right;

            }

            else return ;


        }
    }

    static void heapify(int []a,int i,int n){ // convert the array into heap (maxheap)
       int largest=i;
       int left=2*i;
       int right=2*i+1;

       if(left<n && a[largest] <a[left]){
        largest=left;
       }
       if(right<n && a[largest]<a[right]){
        largest=right;
       }

       if(largest!=i){
        swap(largest, i, a);
        heapify(a, largest, n);
       }
    }

    static void print(int a[]){
        System.out.println();
      for(int i=1;i<=size;i++){
        System.out.print(" "+a[i]);
      }
    }
    public static void main(String[] args) {
      
        int a[]=new int[capacity];

        insert(7, a);
        insert(6, a);
        insert(5, a);
        insert(4, a);
        insert(3, a);
        insert(2, a);
        insert(1, a);
        // insert(0, a);

        print(a);


        
        delete(a);
        delete(a);
        delete(a);
        delete(a);
        print(a);


        int arr[]={-1,54,53,55,52,50,56,78,89,78,45,107}; // for 1 indexed array 
        
        int len=arr.length;
        for(int i=len/2;i>0;i--){
            heapify(arr, i, len);
        }

        System.out.println(Arrays.toString(arr));

    }
}
