import java.util.Arrays;




public class demo2{
        public static int longestSubsequence(int[] arr, int T) {
        int n = arr.length;

        // Create an array to store the length of the longest increasing subsequence ending at each index
        int[] dp = new int[n];

        // Initialize all values to 1, as each element is a valid subsequence of length 1
        Arrays.fill(dp, 1);

        int maxLength = 1;

        // Iterate over the array
        for (int i = 1; i < n; i++) {
            // Check the elements before the current index
            for (int j = 0; j < i; j++) {
                // If the current element is greater than the previous element
                // and the distance between them is within the limit T
                if (arr[i] > arr[j] && Math.abs(arr[i] - arr[j]) <= T) {
                    // Update the length of the subsequence ending at the current index
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Update the overall maximum length
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
    public static void main(String[] args) {
            
        int[] arr = {3, 1, 8, 9,11,14,15, 4};
        int T = 3;

        int result = longestSubsequence(arr, T);
        System.out.println("Length of the longest subsequence: " + result);
    }
    
}