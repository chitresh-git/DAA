public class j52_cycle_dfs {
// CYCLE DETECTION OF UNDIRECTED GRAPH USING - DFS 

    static boolean dfs(int vis[], int e[][], int node, int parent) {

        vis[node] = 1; // mark visited 

        for (int i : e[node]) { // traversing every neighbour node 

            System.out.println(node);
            if (vis[i] != 1) // not visited than , visit that node
                return dfs(vis, e, i, node);

            else if (vis[i] == 1 && i != parent) // but if node is visited and its parent is not equal to current node ,then it
                                                 // means that node is already visited by some one else node , hence
                                                 // cycle is found in graph
                return true;
        }

        return false;     // cycle not found 
    }

    public static void main(String[] args) {
        int v = 7;

        int vis[] = new int[v]; // keep track which node is visited

        int e[][] = { { 1, 2 }, { 0, 4 }, { 0, 3, 5 }, { 2 }, { 1, 6 }, { 2, 6 }, { 4, 5 } };

        if (dfs(vis, e, 0, -1))
            System.out.println("cycle is found");
        else
            System.out.println("cycle is not found ");
    }

}
