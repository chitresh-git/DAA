public class j14_selection2 {
    static void show(int arr[]) {
        for (int e : arr) {
            System.out.print(" " + e);
        }
        System.out.println();
    }

    static int findMin(int a[], int i) {
        int min = i; // current element

        for (int j = i + 1; j < a.length; j++) {

            if (a[j] < a[min]) { // searching for the smallest element in unsorted part of the array by comparing
                                 // wiht current element
                min = j;
            }
        }

        return min;
    }

    static void swap(int a[], int i, int min) {
        int temp = a[min]; // performing the swapping in between the current element with smallest element
        a[min] = a[i];
        a[i] = temp;
    }

    static void selection(int a[]) {
        for (int i = 0; i < a.length; i++) {

            swap(a, i, findMin(a, i)); // calling the swap function , which contains the findMin() function which will eventually return the minimum elements index which has to be passed as parameter for the swap function

            show(a);
        }
    }

    public static void main(String[] args) {
        int a[] = { 6, 4, 2, 0 };
        show(a);
        selection(a);
        show(a);
    }
}
