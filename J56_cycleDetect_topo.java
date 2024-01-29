import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

// cycle detection in directed graph using BFS TOPO SORT ( KAHN'S ALGO)

public class J56_cycleDetect_topo {
    
    static int bfs(int e[][], int v){

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

        
        List <Integer> l=new ArrayList<>(); // store topo sort 

        while(!q.isEmpty()){   
            int node=q.poll(); // removing nodes from stack in fifo manner 
            l.add(node);

            for(int j:e[node]){
                indeg[j]--;    // decreasing the indegree of that adjacent nodes which recieves the current node

                if(indeg[j]==0) // if adjancent nodes indeg becomes 0 then they are added to the stack 
                q.add(j);
            }

        }
       
  
       return l.size();

    }

    public static void main(String[] args) {
        int v=5;
        // int e[][]={{1},{2},{3,4},{4},{}};  // acyclic 
        int e[][]={{1},{2},{3},{4},{4}};       // cyclic 
        
        int topo=bfs(e, v);

        if(v!=topo) // if length of topo sort is not equal to total number of nodes then cycle is present in graph 
        System.out.println("cycle is present in graph ");
        else
        System.out.println("cycle is not present in graph ");

        
    }
}
