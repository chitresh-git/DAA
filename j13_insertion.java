public class j13_insertion {

    static void show(int arr[]){
        for(int e : arr){
            System.out.print(" "+e);
        }
        System.out.println();
    }

    static void insertion(int arr[]){
        System.out.println("sorting started:\n");

        for(int i=1;i<arr.length;i++){
            
            int j=i-1;
            int temp=arr[i]; // pick an element for insertion from unsorted part of the array 

            while(j>=0 && arr[j]>temp){ // compare that picked element with sorted part of the array to find its find position
                arr[j+1]=arr[j]; // shifing the elements to thier correct position
                j--;
            }
            arr[j+1]=temp; // inserting picked element at its final corrected position 
            show(arr);
        }
    }
    public static void main(String[] args) {
        int a[]={5,4,3,2,1};
        System.out.println("array before sorting:\n");
        show(a);
        insertion(a);
        System.out.println("after sorting:");
        show(a);

    }
}
