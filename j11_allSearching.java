import java.util.Scanner;

public class j11_allSearching {

    static int[] getData() {

        Scanner s = new Scanner(System.in);
        System.out.println("\nenter the size of array: ");
        int size = s.nextInt();
        int arr[] = new int[size];

        System.out.println("\nelements must be in ascending order \n enter elements:");

        for (int i = 0; i < size; i++) {

            arr[i] = s.nextInt();
            if (arr[i] < arr[Math.max(0, i - 1)]) {
                i--;
                System.out.println("\nplease enter elements in ascending order ");
            }
        }
        return arr;
    }

    static void show(int arr[]) {
        System.out.println("\nelements are:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static int linearSearch(int arr[], int ele) {
        System.out.println("linear search");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                // System.out.println("element "+ele+" is found at "+i+" index");
                return i;
            }
        }
        // System.out.println("element not founf");
        return -1;
    }

    static int jump(int arr[], int target) {
        System.out.println("jump search");
        int n = arr.length;

        int blockSize = (int) (Math.sqrt(n)); // optimal size of block size if sqaure root of array size

        int low = 0, high = blockSize;

        // starting the jump search
        while (arr[high] <= target && high < n) { // this loop run until arr[high] target and the value high of is lower
                                                  // than length of size n

            if (arr[high] == target || arr[low] == target) { // if target element is present at any of high or low index

                int ans = (arr[high] == target) ? high : low; // found
                return ans;

                // this block of code is not necessary
            }

            low = high; // shifting the range of searching in forward direction
            high += blockSize; // by adding the block size to high

            if (high >= n) { // if high become greator than size of array then , assigning it to the size of
                             // array
                high = n - 1; // THIS CONDITION IS IMPORTANT
            }

        } // end of first while loop
          // END OF JUMP SEARCH

        while (low < high) { // performing linear search
            if (arr[low] == target) {

                return 1; // found
            }
            low++;
        } // end of linear search

        return -1; // element not found

    }

    static int binary(int arr[], int ele) {
        System.out.println("binary search");
        int mid, low, high, i = 0;
        low = 0;
        high = arr.length;
        mid = (low + high) / 2;

        while (low < high) {
            mid = (low + high) / 2;

            if (arr[mid] == ele) {
                // System.out.println("element is found");
                return mid;
            } else if (ele > arr[mid]) {
                low = mid + 1;

            } else {
                high = mid - 1;

            }
            i++;
        }

        return -1;
    }

    static int exponential(int a[], int ele) {
System.out.println("exponential search");
        int i = 0, n = a.length;
        if (a[i] == ele) { // checking the target element at index 0
            System.out.println(" \n element found at index = " + i);
            return 1;
        }
        i++; // increamenting the i with one

        while (i < n && a[i] <= ele) { // loop will run until the search index i is less than total elements and
                                       // current element is less than or equal to target element

            if (a[i] == ele) {
                // System.out.println(" \n element found at index = " + i);

                return i;

            }

            i *= 2; // increamenting the value of search index i exponentially i.e. 1,2,4,8,16....
        }

        return binary(a, ele, i / 2, Math.min(i, n - 1)); // calling the binary search algo , if element is not found in
                                                          // exponential search

    }

    static int binary(int arr[], int ele, int low, int high) {
        int mid, i = 0;
        mid = (low + high) / 2;

        while (low < high) {
            mid = (low + high) / 2;

            if (arr[mid] == ele) {
        
                return mid;
            } else if (ele > arr[mid]) {
                low = mid + 1;

            } else {
                high = mid - 1;

            }
            i++;
        }

       
        return -1;
    }

    public static int interpolation(int arr[], int target) {
System.out.println("interpolaiton search");
        int low = 0;
        int high = arr.length - 1;


        while (high > low && target<=arr[arr.length-1]) {
           

            int ind = low + (((high - low) * (target - arr[low])) / (arr[high] - arr[low])); // bracketing is most
                                                                                             // important

            // System.out.println(ind);

            if (arr[ind] == target) {

                return ind; // found
            }

            if (arr[ind] > target) {

                high = ind - 1;
            } else {
                low = ind + 1;
            }
        

        }
        return -1; // not found

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int raw[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        int flag = 1;
        while (flag==1) {
            System.out.println("\n\nENTER THE INPUT METHOD \n\n1.INPUT MANNUALY \n\n2.TAKE STATIC ARRAY : ");
            int method = s.nextInt();
            int[] arr = (method == 1) ? getData() : raw;
            show(arr);
            System.out.println(
                    "\n\nENTER WHICH TYPE OF SEARCHING YOU WANT \n\n1.LINEAR \n\n2.JUMP \n\n3.BINARY \n\n4.EXPONENTIAL \n\n5.INTERPOLATION :");
            int choice = s.nextInt();
            System.out.println("\n\nenter which element you want to search:");
            int target = s.nextInt();

            int ans = 0;
            switch (choice) {
                case 1:
                    ans = linearSearch(arr, target);
                case 2:
                    ans = jump(arr, target);
                case 3:
                    ans = binary(arr, target);
                case 4:
                    ans = exponential(arr, target);
                case 5:
                    ans = interpolation(arr, target);
                    // default :
                    // System.out.println("please enter correct input : ");
            }

            String res = (ans!=-1) ? "\nelement is found at index = " : "\nelement is not found in the array , return code is = ";

            System.out.println(res + ans);

            System.out.println("\nDo you want to continue \n1.YES \n2.NO :");
            flag=s.nextInt();

        }
    }
}
