// SALES MAN PROBLEM USING DYNAMIC PROGRAMMING 
public class a4_salesMan {
   static int n=4;
   static int dst[][]={
        {0,20,42,25},
        {20,0,30,34},
        {42,30,0,10},
        {25,34,10,0}
    };
   static int visited=(1<<n)-1; // this is 15 as 1 is shifted n (4) bits to left 
//    4 bits left shifting means 2*4 values so 16
    
   static int tsp(int mask,int pos){
    System.out.println(visited);
       
       if(mask==visited){ // if all the cities are visited then we return the cost last visited city to first city 
           return dst[pos][0];
        }
         int ans=Integer.MAX_VALUE;

       for(int city=0;city<n;city++){

        if((mask&(1<<city))==0){ // if city is not visited then we treaverse to that city 

            int tempans=dst[pos][city] + tsp(mask | (1<<city),city); // calculating the cost of travelling the to the new city 
            ans=Integer.min(ans, tempans); // adding the minimum cost to our answer from all the possiblities 

        }
       }

       return ans;
    }

    public static void main(String[] args) {
        System.out.println(tsp(1,0));
        // System.out.println(1<<10);
    }
}
