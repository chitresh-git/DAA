import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// KOSARAJU ALGORITHM - used to find number of scc (strongly connected components )
// this algo can only works on directed graph 

public class j59_kosaraju_scc {
    static Stack<Integer> s = new Stack<>(); // store nodes in sorted order

    static void dfs(int node, int vis[], int e[][]) { // will sort nodes according to thier finishing time , means node
                                                      // which is at last in graph , will be get stored at the bottom of
                                                      // stack
        vis[node] = 1;

        for (int i : e[node]) {
            if (vis[i] == 0)
                dfs(i, vis, e);
        }

        s.add(node);
    }

    static void dfs2(int node, int vis[], List<List<Integer>> adj) { // will perform dfs on reversed graph and helps to
                                                                     // calculate scc
        vis[node] = 1;

        for (int i : adj.get(node)) {
            if (vis[i]==0)
                dfs2(i, vis, adj);
        }
    }

    public static void main(String[] args) {

        int e[][] = { { 1 }, { 2 }, { 0, 3 }, { 4 }, { 5, 7 }, { 6 }, { 4, 7 }, {} };
        int v = 8;
        int vis[] = new int[v];
        int scc = 0;

        List<List<Integer>> adj = new ArrayList<>(); // will store reverse graph

        // -----------------------------------------------------------------------------------
        // step -1 (do sorting of nodes using dfs , and store in stack )
        dfs(0, vis, e);

        // -----------------------------------------------------------------------------------

        // step -2 ( reverse the graph original )
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        for (int node = 0; node < v; node++) { // reversing the graph
            vis[node]=0;
            // node ----> i converting it into i ----> node
            for (int i : e[node])
                adj.get(i).add(node);
        }

        // -----------------------------------------------------------------------------------

        // step -3 (apply dfs on reversed graph)
        while (!s.isEmpty()) { // calculating the scc by counting number of times dfs2() is called at reversed
                               // graph
            int node = s.pop(); // applying dfs2() on elements stored in stack if they are not visited
            if (vis[node] ==0) {
                scc++; // will count scc
                dfs2(node, vis, adj);
            }
        }

        System.out.println("total number of scc in graph is = " + scc);
    }
}

/* 
 * 
class Solution
{
    
     Stack<Integer> s = new Stack<>(); // store nodes in sorted order

     void dfs(int node, int vis[], ArrayList<ArrayList<Integer>> e) { // will sort nodes according to thier finishing time , means node
                                                      // which is at last in graph , will be get stored at the bottom of
                                                      // stack
        vis[node] = 1;

        for (int i : e.get(node)) {
            if (vis[i] == 0)
                dfs(i, vis, e);
        }

        s.push(node);
    }

     void dfs2(int node, int vis[], ArrayList<ArrayList<Integer>> adj) { // will perform dfs on reversed graph and helps to
                                                                     // calculate scc
        vis[node] = 1;

        for (int i : adj.get(node)) {
            if (vis[i] ==0)
                dfs2(i, vis, adj);
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> e)
    {
        //code here
     
        int vis[] = new int[v];
        int scc = 0;

       ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();// will store reverse graph

        // -----------------------------------------------------------------------------------
        // step -1 (do sorting of nodes using dfs , and store in stack )
        for(int i=0;i<v;i++){
            if(vis[i]==0)
            dfs(0, vis, e);
        }

        // -----------------------------------------------------------------------------------

        // step -2 ( reverse the graph original )
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        for (int node = 0; node < v; node++) { // reversing the graph
            // node ----> i converting it into i ----> node
            vis[node]=0;
            for (int i : e.get(node))
                adj.get(i).add(node);
        }

        // -----------------------------------------------------------------------------------

        // step -3 (apply dfs on reversed graph)
        while (!s.isEmpty()) { // calculating the scc by counting number of times dfs2() is called at reversed
                               // graph
            int node = s.peek(); // applying dfs2() on elements stored in stack if they are not visited
            s.pop();
            if (vis[node]==0) {
                scc++; // will count scc
                dfs2(node, vis, adj);
            }
        }
        
        return scc;
    }
}

 */