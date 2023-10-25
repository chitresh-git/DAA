public class j16_quick {
    static void show(int arr[]) {
        for (int e : arr) {
            System.out.print(" " + e);
        }
        System.out.println();
    }

    static int partition(int a[], int low, int high) {
        int pivot = a[low];
        int i = low + 1;
        int j = high;
        int temp;

do{
    while(a[i]<=pivot){ // this less than (<=) equal to condition is most important 
        i++;
    }
    while(a[j]>pivot)
    {
        j--;
    }
    if(i<j){ // swapping the  i and j index element when element of index i is greater and element of index j is smaller than the pivot  
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}while(j>=i);

temp=a[low]; // as soon as j crosses the i , we will swap pivot with element of index j 
a[low]=a[j];
a[j]=temp;
return j;
    }

    static void quick(int a[], int low, int high) {
        if (high > low) {
            int partInd = partition(a, low, high);

            quick(a, partInd + 1, high); // solving for right part of array 
            show(a);
            quick(a, low, partInd - 1); // solving for left part of the array 
        }
    }

    public static void main(String[] args) {
        int a[] = { 1,8,6,4,2,0,10};
        show(a);
        quick(a, 0, a.length - 1);
        show(a);

    }
}
