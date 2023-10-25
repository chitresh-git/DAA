import java.util.Scanner;

public class j3_delete {
     static int[] take(int[] arr, int size) {

        Scanner s = new Scanner(System.in);

        System.out.println("enter elements:");

        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    static void traverse(int arr[], int size) {
        System.out.println("elements are:");
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }



    static int deletion(int [] a,int size,int index){
        if(size<=0){
            System.out.println("array is underflow , deletion can not be done");
            return size;
        }
        int del=a[index];
        for(int i=index;i<size;i++){
            a[i]=a[i+1];
        }
        size--;
        System.out.println(del+" is deleted from the array");
        return size;
    }
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
        int capacit, size,index,element;

        System.out.println("enter the capacity of arra:");
        capacit = s.nextInt();
        int arr[] = new int[capacit];
        System.out.println("enter how many elements you want to enter:");
        size = s.nextInt();

        arr = take(arr, size);

        traverse(arr, size);

   

        System.out.println("enter the index for deletion");
        index=s.nextInt();

        size=deletion(arr, size, index);

        traverse(arr, size+1);
    }
}
