public class j20_radix {

    static void show(int arr[]) {
        for (int e : arr) {
            System.out.print(" " + e);
        }
        System.out.println();
    }

    static int getmax(int a[]){ // this will return max element of array 
        int m=a[0];
        for (int e:a){
            if(e>m){
                m=e;
            }
        }
        return m;
    }

    static void count(int a[], int p){
        int count[]=new int[10]; // this will count the frequencies of the element according to the places
        int temp[]=new int[a.length]; // this hold elements in sorted manner in each pass

        int i;

        for(i=0;i<a.length;i++){
            count[(a[i]/p)%10]++; // calculating the frequencies of elements by thier places and storing it in count array
        }

        for(i=1;i<count.length;i++){ // updating the count array with its cumulative sum
            count[i]=count[i]+count[i-1];

        }

        for(i=a.length-1;i>=0;i--){ // copying the elements from original array into temp in sorted according to place value in each pass
            temp[count[(a[i]/p)%10] - 1]=a[i];
          
            count[(a[i]/p)%10]--;

        }

        for(i=0;i<a.length;i++){ // copying back elements from temp into orginal array a
           a[i]=temp[i];
        }
    }

    static void radix(int a[]){
        int m=getmax(a); // calculating the max element of array

        for(int p=1;(m/p)>0;p*=10){ // this will call the count for ones , tens , hundredes and ...so on places
            count(a,p);
        }

    }
    public static void main(String[] args) {
        int a[] ={8,6,5,3,12,65,23,98,9878,23,7534,23,544,90,0};
        show(a);
        radix(a);
        show(a);

    }
}
