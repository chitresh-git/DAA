import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//  BRIDGES IN GRAPH 
// trojan's algorithm is used to find number of bridges in any graph 

public class j60_bridge {
    
   static int timer=1;
   
   static List<List<Integer>> b= new ArrayList<>(); // store bridge edges 

    static void dfs(int node , int parent ,int vis[], int time[] , int low[], int e[][]){
        vis[node]=1;                // marking node as visited 
        time[node]=low[node]=timer; // storing time and low for current node 
        timer++;

        for(int i:e[node]){          // traversing the adjacents of current node 
            if(i==parent) continue; // skipping the if adjacent is parent of current node 

            if(vis[i]==0){          // if adjacent is unvisited then calling dfs() for it 
                dfs(i, node, vis, time, low, e); 


                if(time[node]<low[i])     // time of node is smaller than low of its adjacent then it means that edge is bridge
                b.add(Arrays.asList(node,i));  // storing that edge(bridge)
            }
            
                low[node]=Math.min(low[i], low[node]);  // updating the low of node with minimum 
            
        }
    }

    public static void main(String[] args) {
        int v=9;
        int vis[]=new int[v];

        int time[]=new int[v]; // store time of insertion for nodes 

        int low[]=new int[v];  // store lowest time to reach any node via any of its adjacent node

        int e[][]={{1,3},{0,2},{1,3},{0,4},{3,5},{8,6},{5,7},{8,6},{5,7}};

        dfs(0, -1, vis, time, low, e);

        System.out.println("total number of bridges in graph is ="+b.size());

        // printing bridges 
        System.out.println("bridges are : ");
        for(int i=0;i<b.size();i++){
            System.out.println(b.get(i));
        }
    }
}
