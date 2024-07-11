import java.util.HashMap;

class sample{

    static int  max (int a[]){
        int maxval=Integer.MIN_VALUE;

        for(int i:a){
            maxval=Math.max(maxval,i);
        }

        return maxval;
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int a[]={1, 2, 3, 4, 1, 2, 2, 3, 1, 4, 4, 4};
        
       int maxi= max(a);

       int hash[]=new int[maxi+1];

       for(int i=0;i<a.length;i++){
        hash[a[i]]++;
       }

       for(int i=0;i<hash.length;i++){
        if(hash[i]!=0)
        System.out.println("element:"+i+"value:"+hash[i]);
       }
        
    }
}