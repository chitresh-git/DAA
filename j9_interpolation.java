public class j9_interpolation {
// this algorithm can only be implement on sorted array and 
// all the difference between all the elements should be equidistant

    public static int interpolation(int arr[], int target){
    
        int low=0;
        int high=arr.length-1;


        int ind = low+ (((high - low)  * (target - arr[low])) / (arr[high] - arr[low] ) ); // bracketing is most important
        
       

      
        return ind;

    }
    public static void main(String[] args) {
        int a[] = {1,3,5,7,9,11,13,15};

        int target=11,ans=interpolation(a,target);
        
        String res=(a[ans]==target)?"element is found":"element is not found";
        System.out.println(res);


    }
    
}

