class sumSubset{
    boolean sos(int [] set, int target, int n,int curInd){
        if(target==0)// when target becomes 0 it means targeted value is found using sum of subset 
        return true;

        if(curInd>=n) // current index exceeds the size of set therefor we return false
        return false;

        if(set[curInd]<=target && sos(set, target-set[curInd], n, curInd+1)){ // adding the current index int the subset as we subtracting its value from the target 

            return true;
        }

        return sos(set, target, n, curInd+1); // removing the current index from the subset and call calling for next index
    }
}
public class a6_sumofSubset {
    public static void main(String[] args) {
        int a[]={4,2,1,5,67};
        int n=a.length;
        int target=3; // targeted value 

        sumSubset s=new sumSubset();
        boolean ans=s.sos(a, target, n, 0);

        if(ans)
        System.out.println(" yes subset exist");
        else
        System.out.println("subset doesnt exist for the value "+ans);
    }

    
}
