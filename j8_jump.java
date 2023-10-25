public class j8_jump {

    static int jump(int arr[], int target) {
        int n = arr.length;

        int blockSize = (int) (Math.sqrt(n)); // optimal size of block size if sqaure root of array size

        int low = 0, high = blockSize;
        
        // starting the jump search 
        while (arr[high] <= target && high < n) { // this loop run until arr[high] target and the value high of is lower
                                                  // than length of size n

            if (arr[high] == target || arr[low] == target) { // if target element is present at any of high or low index

                return 1; //found
                // this block of code is not necessary
            }

            low = high; // shifting the range of searching in forward direction
            high += blockSize; // by adding the block size to high

            if (high >=n) { // if high become greator than size of array then , assigning it to the size of
                            // array
                high = n - 1; // THIS CONDITION IS IMPORTANT
            }

        }// end of first while loop 
        // END OF JUMP SEARCH 

        while (low < high) { // performing linear search 
            if (arr[low] == target) {

                return 1; // found
            }
            low++;
        }// end of linear search 

        return -1; // element not found 

    } 

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 12, 14, 16, 18, 20};

        int ans = jump(arr, 20);

        String max = (ans == 1) ? "element is found" : "element is not found";

        System.out.println(max);

    }
}
