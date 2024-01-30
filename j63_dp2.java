// fabonacci using tabulation method

public class j63_dp2 {
    
    static int fab(int n , int dp[]){
       dp[0]=0; // base cases 
       dp[1]=1;

       for(int i=2;i<=n;i++){ 
        dp[i]=dp[i-1]+dp[i-2]; // generating new result using previously stored values in table
       }

       return dp[n];
    }

    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1]; //  table for tabulation

        int ans=fab(n, dp);
        System.out.println(ans);
    }
}
