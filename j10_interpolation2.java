public class j10_interpolation2 {
    // when the array is sorted but
    // not contains equidistant elements
    public static int interpolation(int arr[], int target){
    
        int low=0;
        int high=arr.length-1;
        int step=1;

        while(high>low && target<arr[arr.length-1]){
        System.out.println("step="+step);


        int ind = low+ (((high - low)  * (target - arr[low])) / (arr[high] - arr[low] ) ); // bracketing is most important
        
    //    System.out.println(ind);
       

       if(arr[ind]==target){

           return ind; // found 
       }

      if(arr[ind]>target){

          high=ind-1;
      }
      else{
        low=ind+1;
      }
       step++;
      
        }
        return -1; // not found 

    }
    public static void main(String[] args) {
        int a[] = {1,3,5,14,21,25,26,29,100};

        int target=100,ans=interpolation(a,target);
        
        String res=(a[ans]==target)?"element is found":"element is not found";

        System.out.println(res+"at index = "+ans);


    }
}
