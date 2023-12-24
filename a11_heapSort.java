public class a11_heapSort {

    static void heapSort(int a[]) {
        int n = a.length;
        
        // to make maxHeap pass the elements of array in reverse order , to make min heap pass them in original order 
        for (int i=n;i>=0;i--) { // create the heap using maxHeap() , this will rearrange the array in
                                               // heapify order
            maxHeap(a, n, i);
        }
        System.out.println("after heapifying , the maxHeaped array is : ");
        show(a);

        for (int i = n-1; i >= 0; i--) { // deleleting the element one by one from the heap

            int temp = a[0]; // swapping the root with end element
            a[0] = a[i];
            a[i] = temp;

            maxHeap(a, i, 0);
        }
    }

    static void maxHeap(int a[], int n, int i) {
        int largest = i; // i is root , and we know that in maxheap root must be largest

        int l = (i * 2) + 1; // left child index
        int r = (i * 2) + 2; // right child index
        
        if (l < n && a[l] > a[largest]) // if left child is greater than root
        largest = l;
        
        if (r < n && a[r] > a[largest]) // if right child is greater than root elment
            largest = r;

        if (largest != i) { // if root is not the largest element's index than swap the root with largest
                            // indedx

            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            
            i=largest;// making maximum elements index as root index
            maxHeap(a, n, i); // again recursively call the maxheap()
        }

    }

    static void show(int a[]) {
        for (int e : a)
            System.out.print(e + " ");
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int[] a = {0,23,9, 10, 20, 15, 30, 40 };
        System.out.println(" initially array will look this :");
        show(a);

        heapSort(a);

        System.out.println("after deleting the elements from heap , we will get sorted array : ");
        show(a);

    }
}
