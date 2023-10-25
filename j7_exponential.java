public class j7_exponential {

    static int binary(int arr[] , int ele , int low, int high){
        int mid ,i=0;
        mid=(low+high)/2;
       
        while(low<high){
                    mid=(low+high)/2;
                 

            if(arr[mid]==ele){
            System.out.println(" \n element found at index = "+mid+" in binary search algo");
                return 1;
            }
            else if(ele>arr[mid]){
                low=mid+1;
               
            }
            else{
                high=mid-1;
           
            }
            i++;
        }
        
        System.out.println("not found");
        return -1;
    }
    
    static int exponential(int a[] , int ele ){

        int i=0,n=a.length;
        if(a[i]==ele){  // checking the target element at index 0
            System.out.println(" \n element found at index = "+i);
return 1;
        }
        i++; // increamenting the i with one 

        while(i<n && a[i]<=ele){ // loop will run until the search index i is less than total elements and current element is less than or equal to target element 

            if(a[i]==ele){
            System.out.println(" \n element found at index = "+i);

                return 1;

            }

            i*=2; // increamenting the value of search index i exponentially i.e. 1,2,4,8,16....
        }
     

      return  binary(a,ele,i/2,Math.min(i, n-1)); // calling the binary search algo , if element is not found in exponential search 

        
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,12,13,14,15,45,56,78,89,90};

        exponential(arr, 8);
        
    }
}
