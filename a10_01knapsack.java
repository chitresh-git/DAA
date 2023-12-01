public class a10_01knapsack {
    // 0/1 KNAPSACK PROBLEM using dynamic progmming by tabular approach or bottum up approch
   static void calKnapsack(int cap, int n, int [] wghts, int[] prft){

        int i,w; // i represent the object id and w represent the wieghts in matrix
        int temp[][]=new int[n+1][cap+1]; // temprary matrix for tabulation

        for(i=0;i<=n;i++){

            for(w=0;w<=cap;w++){
                if(i==0 || w==0){
                    temp[i][w]=0;
                }
                else if(wghts[i-1]<=w){
                    temp[i][w]=Math.max(temp[i-1][w], temp[i-1][w-wghts[i-1]]+prft[i-1]); // applying the tabular dynamic formula
                }
                else{
                    temp[i][w]=temp[i-1][w];
                }
            }
        }

        System.out.println(temp[n][cap]);
    }

    public static void main(String[] args) {
        int profit[] = new int[] { 1,2,5,6}; 
        int weight[] = new int[] { 2,3,4,5}; 
        int cap =8;                         // capacity 
        int n = profit.length; 

        calKnapsack(cap, n, weight, profit);
    }
}
