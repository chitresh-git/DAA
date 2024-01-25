import java.util.Queue;
import java.util.LinkedList;
// CYCLE DETECTION OF UNDIRECTED GRAPH USING - BFS 

public class j51_CYCLE_BFS {
   
   static int common;
   static class pair{
        int node , parent;
        pair(int a, int b){
            node=a; // will store current node
            parent=b; // will store the parent of current node 
        }
    }
    
   static boolean detect(int start,int e[][],int vis[]){
        
        vis[start]=1;

        Queue <pair> q=new LinkedList<>();
        q.add(new pair(start, -1)); // adding starting node and its parent as -1

        while(!q.isEmpty()){
            int node=q.peek().node;     // current node 
            int parent=q.peek().parent; // parent of current node 

            q.poll();

            for(int i:e[node]){
                
                if( vis[i]==1 && i!=parent) {   // when node is already visited and its not equal to parent of current node
                    common=i;                   // then it means that there is cycle in graph 
                    return true;
                }
                else if(vis[i]==0){            // else traverse non visited nodes 
                    vis[i]=1;
                    q.add(new pair(i, node));
                } 
                }
        }

        return false;
        
    }

    public static void main(String[] args) {
        int v=7;

        int vis[]=new int[v]; // keep track which node is visited

        // int e[][]={{2,3,},{1,5},{1,4,6},{3},{2,7},{3,7},{5,6}};
        int e[][]={{1, 2}, {0, 4}, {0, 3, 5}, {2}, {1, 6}, {2, 6}, {4, 5}};

        boolean ans=detect(0, e, vis);
        if(ans) System.out.println("cycle detected at the node : "+common);
        else System.out.println("no cycle found");
    }
}
