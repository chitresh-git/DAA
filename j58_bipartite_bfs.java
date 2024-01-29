import java.util.LinkedList;
import java.util.Queue;
// CHECKS WHETHER THE GRAPH IS BIPARTITE OR NOT USING - BFS

public class j58_bipartite_bfs {
    static boolean bfs(int start , int color[],int e[][]){
        Queue <Integer> q=new LinkedList<>() ;
        
        color[start]=1;   // marking starting node as red (1)
        q.add(start);     // adding to the queue 

        while(!q.isEmpty()){
            int node=q.poll(); // removing the node from the queue in fifo manner 

            for(int i:e[node]){ // traversing the adjacent nodes of current node

                if(color[i]==0){ // if adjancent node is uncolored then coloring it 
                    color[i]=3-color[node];     // 3-color[node] will give the opposite of current node's color 
                    q.add(i);
                }
                else if(color[i]==color[node])   // but if adjacent node is colored and it is same as current node's color then it means that graph cant be bipartite 
                return false;                    // so return false 
            }
        }

        return true;      
    }

    public static void main(String[] args) {
        int v=6;
        int color[]=new int[v]; // willl store color;  red=1 and green=2
           
        int e[][]={{1},{0,2,3},{1,4},{1,4},{2,3,5},{4}};

        boolean ans=bfs(0, color, e);
        if(ans)
        System.out.println("graph is bipartite");
        else
        System.out.println("graph is not bipartite");
    }
}
