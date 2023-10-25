public class j19_count {

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

    static void count (int a[]){
        int m=getmax(a);
        int count[]=new int[m+1]; // creating a count array of size maximum element + 1 

        int i,j;
        for(i=0;i<a.length;i++){ // counting the frequencies of elements and storing it in count array 
            count[a[i]]+=1;
        }

        i=0;
        j=0;
        while(j<a.length){ // copying the indexes of count array as an element in original array in sorted manner 
            if(count[i]>0){
                a[j]=i;
                j++;
                count[i]--;
            }
            else{
                i++;
            }
        }

    }
    public static void main(String[] args) {
        int a[]={8,6,4,3,2,145,0,2,2,8,12,33};
        show(a);
        
        count(a);
        show(a);
    }
}
