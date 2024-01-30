// DYNAMIC PROGRAMMING
// calculating fabonacci number using memorization table

public class j62_dp {
   
    static int fab(int n, int dp[]) {
        // base case
        if (n <= 1)
            return n; // if n==1 or n==0 then return n

        // if calculation for n is already done , then no need make recursive call for
        // nth element , just return result of n from memorization table
        if (dp[n] != -1)
            return dp[n];

        dp[n] = fab(n - 1, dp) + fab(n - 2, dp); // if result is not already stored then make recursive call and store  the result memorization table for that element
                                               

        return dp[n]; // return the stored result from dp array

    }

    public static void main(String[] args) {
        int n = 5; //

        int dp[] = new int[n + 1]; // used to store results by performin memorization

        for (int i = 0; i < n + 1; i++) { // initializing with -1
            dp[i] = -1;
        }

        int ans = fab(n, dp);

        System.out.println(ans);

    }
}
