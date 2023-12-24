public class j6_binary{

    static int binary(int arr[] , int ele){
        int mid , low, high,i=0;
        low=0;
        high=arr.length;
       
        while(low<high){
                    mid=(low+high)/2;
                    System.out.println("pass="+i+"low="+low+"high="+high+"mid="+mid);

            if(arr[mid]==ele){
                System.out.println("element is found");
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

        return -1;
    }
    public static void main(String[] args) {

        int arr[]={2,4,6,8,12,13,14,15,45,56,78,89,90};

        binary(arr, 78);
        
    }
}
