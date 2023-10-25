import java.util.Scanner;

public class j1_traversal {

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

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int capacit, size;

        System.out.println("enter the capacity of arra:");
        capacit = s.nextInt();
        int arr[] = new int[capacit];
        System.out.println("enter how many elements you want to enter:");
        size = s.nextInt();

        arr = take(arr, size);

        traverse(arr, size);

    }
}
