public class j5_linearSearch {
    

    static int linearSearch(int arr[] , int ele){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                System.out.println("element "+ele+" is found at "+i+" index");
                return 1;
            }
        }
        System.out.println("element not founf");
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={12,3,232,32,2,32,2,34};
        linearSearch(arr, 5);

    }
}
