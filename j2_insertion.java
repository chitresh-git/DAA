import java.util.Scanner;

public class j2_insertion {

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


    static int insertion(int [] a ,int size, int capacity, int element, int index){

        if(size>=capacity){
            System.out.println("array is full, insertion is not done ");
            return size;
        }

        for(int i=size;i>=index;i--){
            a[i+1]=a[i];

        }
        a[index]=element;
        size++;
        System.out.println("insertion completed");
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

        System.out.println("enter the element you want to insert");
        element=s.nextInt();

        System.out.println("enter the index for insertion");
        index=s.nextInt();

        size=insertion(arr, size, capacit, element, index);

        traverse(arr, size);
    }
    
}
