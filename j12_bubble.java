public class j12_bubble {

    // in BUBBLE SORT  algo , we start the traversing from the left and compare with each adjacent element 
    //  during comparision the larger elemnts will shifted towardd right , it means the largest element is present at the right most index and smallest element is present at the left most index in  array at the end of sorting 

    static void show(int[] arr) {
        for (int e : arr) {
            System.out.print(" " + e);
        }
        System.out.println("");
    }

    static void bubble(int arr[]) {
        int pass = 1;
        boolean f = true; // this condition is use to make bubble sort algo adaptive
        for (int j = 0; j < arr.length - 1; j++) {
            System.out.println("pass=" + pass);
            for (int i = 0; i < arr.length - j - 1; i++) {

                if (arr[i] > arr[i + 1]) { // comparing the adjacent elements
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[i + 1]; // performing swapping 
                    arr[i + 1] = temp;
                    f = false;

                }
                show(arr);
            }
            if (f) // if no comparision occur in inner loop then this condition will gets true and
                   // outer loop will get break
                break;
            pass++;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 7, 6, 5, 4, 3, 2, 1 };
        show(arr);
        bubble(arr);
        show(arr);
    }
}
