public class j18_merge {

    static void show(int arr[]) {
        for (int e : arr) {
            System.out.print(" " + e);
        }
        System.out.println();
    }

    static void merge(int a[], int low, int high, int mid , int size) {
       
        int i,j, mainInd;
         i = mainInd=low; // i represent the pointer for left side of the array
         j = mid + 1;// j represent the pointer for right side of the array

        int copy[] = new int[size]; // creating an temprory array of the size same as orginal array 

        while ( i <= mid && j <= high) {

            if (a[i] < a[j]) {
                copy[mainInd] = a[i];
                mainInd++;
                i++;
            } else {
                copy[mainInd] = a[j];
                mainInd++;
                j++;
            }
        }

        while (i <= mid) {
            copy[mainInd] = a[i];
            mainInd++;
            i++;
        }
        while (j <= high) {
            copy[mainInd] = a[j];
            mainInd++;
            j++;
        }

        for (int k =low; k <=high; k++) { // copying the sorted elements from temp array to the original array
            a[k] = copy[k];
        }
    }

    static int mergeSort(int a[], int low, int high,int size) {
        if (low >= high) {
            return 0;
        } else {
            int mid = (low + high) / 2;

            mergeSort(a, low, mid,size); // calling for the left part of the array 
               // this will divide the array to one single array using recursion
            mergeSort(a, mid + 1, high,size); // calling for the right of the array 

            merge(a, low, high, mid,size); // this will merge the array in sorted order
        }
        return 1;
    }

    public static void main(String[] args) {
        int a[] = { 1,8,6,4,2,0,10,-1};
        int n = a.length;
        show(a);
        mergeSort(a, 0, n - 1 ,n);
        show(a);

    }
}
