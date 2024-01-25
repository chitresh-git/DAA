import java.util.LinkedList;
import java.util.Queue;
// TOPOLOGICAL SORT USING - BFS (KAHN'S ALGORITHM)
// only applicable on DAG ( DIRECTED ACYCLIC GRAPH )

public class j55_topological_bfs {
    
   static void bfs(int e[][], int v){

        int indeg[]=new int[v];// will store the indegree of nodes 

        for(int i=0;i<v;i++){    // calculating indegrees 
            for(int node:e[i]){
                indeg[node]++;
            }
        }
        
        Queue <Integer> q=new LinkedList<>();

        for(int i=0;i<v;i++){   // nodes having 0 indegree will be addded to the stack s 
            if(indeg[i]==0)
            q.add(i);
        }

        
        int ans[]=new int[v]; // store topo sort 
        int i=0;

        while(!q.isEmpty()){   
            int node=q.poll(); // removing nodes from stack in fifo manner 
            ans[i++]=node;

            for(int j:e[node]){
                indeg[j]--;    // decreasing the indegree of that adjacent nodes which recieves the current node

                if(indeg[j]==0) // if adjancent nodes indeg becomes 0 then they are added to the stack 
                q.add(j);
            }

        }

        for(int k:ans){
            System.out.println(k);
        }

    }

    public static void main(String[] args) {
        int e[][]={{},{},{3},{1},{0,1},{0,2}};

       bfs(e, 6);
    }
}
