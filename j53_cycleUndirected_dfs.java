// CYCLE DETECTION FOR DIRECTED GRAPH USING - DFS

public class j53_cycleUndirected_dfs {
   static int cycle;
    static boolean dfs(int node,int vis[],int path[],int e[][]){
        
        vis[node]=1;   // marking current node and path as visited 
        path[node]=1;

        for(int i:e[node]) // traversing the adjacent nodes of current node 
        {
            if(vis[i]==0){ // if adjacent node is not visited then we will visit it by calling dfs()

                if(dfs(i, vis, path, e)==true)
                    return true;         
            }

            else if(vis[i]==1 && path[i]==1){ // if adjancent node is already visited and we reached to it using same path 
                return true;
            }
        }

        path[node]=0;   // till this point we doesnt find the cycle , then we backtracked to the previos node , and we also update the path for current node by marking it as unvisited 
        return false;
    }

    public static void main(String[] args) {
        int e[][]={{1},{2},{3,6},{4},{5},{},{4},{8,1},{9},{7}};

       
        boolean ans=false;
         int V=10;
         int vis[]=new int[V]; // keep track which node is visited or not 
        int path[]=new int[V]; // keep track which path is followed
    

        for(int i=0;i<V;i++){
            if(vis[i]==0){ // if node is not visited then only we will call the dfs()

                if(dfs(i, vis, path, e)==true){  // if cycle is found then we stop the searching 
                    ans=true;
                    break;
                }
                
            }
           
        }

        System.out.println(ans);
    }
}

