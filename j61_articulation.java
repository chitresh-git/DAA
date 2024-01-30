import java.util.ArrayList;
import java.util.List;
// ARTICULATION POINT IN GRAPH


public class j61_articulation {
    
    static int timer=1;
    static List<Integer> l=new ArrayList<>(); // store articulation point

    static void dfs(int node ,int parent, int vis[], int time[],int low[],int e[][]){
      vis[node]=1;   // marking current node as visited 

      time[node]=low[node]=timer;  // updating current node's low and time 
      timer++;
      int child=0; // calcualte child of starting node 

      for(int i : e[node]){    // traversing the adjacents of current node
        if(i==parent) continue; // adjacent is parent of current node then skipping that 

          if(vis[i]==0){       // if any adjacent is not visited then calling dfs() for it 
              dfs(i,node, vis, time, low, e);

              low[node]=Math.min(low[i], low[node]); // updating low of current node with minimum of adjacent low 
              
              // if low of adjacent is higher or equal to low current node ,
              // and if current node is not a starting node 
              //  then the current node is said to be articulation point 
              if(low[i]>=time[node] && parent!=-1 && !l.contains(node))  // also current node is should not already  been present in list
              l.add(node);
              
              child++;

        }
        else{
            low[node]=Math.min(time[i], low[node]);  // if adjacent node is already visited then updates the low of current node with minimum time of adjacent 

        }
      }
      if(child>1 && parent==-1 && !l.contains(node)) // if starting node has more than one child , then starting node is said to be  articualtion point 
      l.add(node);

    }

    public static void main(String[] args) {
        int v=7;

        int time[]=new int[v]; // store insertion time of nodes using dfs 
        int low[]=new int[v];  // store lowes insertion time for any of adjacent node except parent 
        int vis[]=new int[v];  // store which node is visited or not 

        int e[][]={{1,2,3},{1},{0,3,4,5},{2,0},{2,6},{2,6},{4,5}};
         
        for(int i=0;i<v;i++){
            if(vis[i]==0)
            dfs(0, -1, vis, time, low, e);
        }

        System.out.println(l.size());
        for(int i:l)
        System.out.println(i);
    }
}
