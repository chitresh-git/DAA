import java.util.Arrays;

public class j68_heap_sort {
    
    static void swap(int b , int c, int a[]){
        int temp=a[b];
        a[b]=a[c];
        a[c]=temp;
    }

   static void maxheap(int a[],int n,int i){
        int largest=i;
        int left=2*i;
        int right=2*i+1;

        if(left<=n && a[largest]<a[left]){
            largest=left;
        }

        if(right<=n && a[largest]<a[right]){
            largest=right;
        }

        if(largest!=i){
            swap(largest,i,a);
            maxheap(a, n, largest);
        }
    }



    static void heapsort(int a[],int n){
      
        int size=n;

        while(size>1){
            swap(1, size, a);
            size--;

            maxheap(a, size, 1);
        }
    }
    public static void main(String[] args) {
        int a[]={-1,54,53,52,55,50,45,78,90,23,545,1,6,94}; // for 1 indexed array 

        int len=a.length;
        for(int i=len/2;i>0;i--){
            maxheap(a, len-1, i);
        }

        heapsort(a, len-1);

        System.out.println(Arrays.toString(a));


    }
}
