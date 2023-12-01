import java.util.Arrays;

class Job{
     int profit, deadline;
     char id;

    Job(int a , int b , char c){ // creates job object with id , profit and deadline
        id=c;
        profit=a;
        deadline=b;

    }
}

public class a7_jobsequence {
    
   static void calProfit(Job [] job){
        int n=job.length;

        Arrays.sort(job,(a,b)->b.profit-a.profit); // will sort the jobs object based on profits in descending order

        boolean slots[]=new boolean[n]; // will store whether the slot is occupied or not
        int result[]=new int[n];        // store the index job id which fills the slot 

        for(int i=0;i<n;i++){
            for(int j=Math.min(n, job[i].deadline)-1;j>=0;j--){
                if(!slots[j]){
                    slots[j]=true;
                    result[j]=i;
                    break;
                }
            }
        }

        int totalp=0;
        for (int i = 0; i < n; i++) {
            if (slots[i]) {
                System.out.println(job[result[i]].id + " ");   
                totalp+=job[result[i]].profit;   
            }
        }
        System.out.println("total optimal profit is : "+totalp);
    }

    public static void main(String[] args) {
        Job []jobs={
            new Job(100, 2, 'a'),
            new Job(19, 1, 'b'),
            new Job(27, 2, 'c'),
            new Job(25, 1, 'd'),
            new Job(15, 3, 'e')
        };
calProfit(jobs);
        
    }
}
