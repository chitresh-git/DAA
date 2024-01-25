// DEPTH FIRST SEARCH IN GRAPH 

public class j50_DFS_G {
   static void dfs(int node,int e[][],boolean vis[]){

        System.out.println(node);         // printing the node and marking it as a true 
        vis[node]=true; 

        for(int i:e[node]){      // traversing the neighbouring node of printed node
            if(vis[i]!=true)      // and if its not visited yet then we will call the dfs() for that neighbour node
            dfs(i, e, vis);
        }
    }

    public static void main(String[] args) {
        int e[][]={{2},{2,3},{1,4},{1,4},{2,3}};

        int start=0;   // starting node
        int v=0;       // no. of nodes 
        boolean vis[]=new boolean[v]; // will keep a track which node is visited or which is not 

        dfs(start, e, vis);
    }
}
