public class j64_recursionn {
   

    static void func1(int n, int sum){ // parametarized call will return sum n numbers
        if(n<1){
            System.out.println(sum);
            return;
        }

        func1(n-1, sum+n);
    }

    static int func2(int n){  // functional call return sum of n numbers
        if(n==0)
        return 0;

        return n+func2(n-1);
    }

    static void rev(int i, int j, int a[]){  // reversing an array 
        if(j<=i)
        return ;

        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;

        rev(i+1, j-1, a);

        
    }

    static boolean check(int i, int j , char a[]){ // checking if string is palindrome or not 
        if(j<=i) return true;

        if(a[i]!=a[j]) return false;

        return check(i+1, j-1, a);
    }

    public static void main(String[] args) {
        func1(4, 0);

        

        System.out.println(func2(10));


        int a[]={1,2,3,4,5};

       rev(0, a.length-1, a);

        for(int i:a)
        System.out.println(i);

        String s="maddama";

        char ar[]=s.toCharArray();

        System.out.println(check(0, ar.length-1, ar));
    }
}
