import java.util.Stack;
// TOPOLOFICAL SORT using -DFS 
// only applicable on directed acyclic graph (DAG)
public class J54_topological_sort {
    static Stack<Integer> s=new Stack<>(); // will store nodes for topological sort

  static  void dfsSort(int node , int vis[] , int e[][]){

       vis[node]=1;       // marking the current node as visited 

       for(int i:e[node]){  // calling dfs for unvisited adjacent nodes of current node
           if(vis[i]==0){
               dfsSort(i, vis, e);
            }
        }

        s.push(node);   // adding nodes in stack accordingly 

    }

    static void show(int V){     // printing the nodes stored in stack in LIFO order will gives topogical sort of graph 
        for(int i=0;i<V;i++){
            System.out.print(" "+s.pop());
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int V=6;
        int vis[]=new int[V];
        int e[][]={{},{},{3},{1},{0,1},{0,2}};

        
        for(int i=0 ;i<V;i++){  // always starts form node 0

            if(vis[i]==0)       // calling dfs() only for unvisited nodes 
            dfsSort(i, vis, e);

        }
        
        System.out.println("topological sort is : ");
        show(V);
    }
}
