import java.util.ArrayList;
// in this program we will learn about difference between creating the arraylist in the recursion call or passing it as argument 

public class j65_recursion_2 {
    

   static ArrayList<Integer> cal(int i,int n,int target,ArrayList<Integer> l , int a[] ){ // passing the arraylist as argument

        if(i==n) return l;

        if(a[i]==target) l.add(i);

        return cal(i+1,n,target,l,a);
    }

    static ArrayList<Integer> cal2(int i, int n , int target, int a[]){
        ArrayList<Integer> temp=new ArrayList<>();

        if(i==n) return temp;

        if(a[i]==target) temp.add(i);
        
        ArrayList<Integer> ans=cal2(i+1, n, target, a);

        temp.addAll(ans);

        return temp;


    }

    public static void main(String[] args) {
        int a[]={1,2,3,4,4,3,6,1};

        int target=4;

        ArrayList<Integer> ans=new ArrayList<>();
        System.out.println("calling the recursion and passing arraylist as argument ");
        cal(0, a.length, target, ans, a);

        for(int e:ans) System.out.println(e);
        

        System.out.println("calling recursion which create arraylist in the recursion call");
        target=1;
        ans=cal2(0, a.length, target, a);
       
        for(int e:ans) System.out.println(e);



    }
}
