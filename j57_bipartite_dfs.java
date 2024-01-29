public class j57_bipartite_dfs {
    // CHECKS GRAPH IS BIPARTITE OR NOT USING - DFS

    static boolean dfs(int node, int color, int col[], int e[][]) {

        col[node] = color;// coloring the current node

        for (int i : e[node]) { // traversing the adjacent nodes of current node

            if (col[i] == 0) { // if adjacent node is uncolored , then call for it dfs()
                if (dfs(i, 3 - color, col, e) == false) ; // 3-color will gives the apposite color of current node
                return false;

            } else if (col[i] == col[node]) // if adjacent node is colored but its color is same as current node's color
                                            // , it means graph is not a bipartite
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int v = 8;
        int e[][] = { { 1 }, { 2, 5 }, { 1, 3 }, { 2, 4, 6 }, { 3, 5 }, { 1, 4 }, { 3, 7 }, { 6 } };

        int col[] = new int[v]; // will store color;  red=1 and green=2

        boolean ans = true;
        for (int i = 0; i < v; i++) {
            if (col[i] == 0)
                ans = dfs(i, 1, col, e);

        }

        if (ans)
            System.out.println("graph is bipartite");
        else
            System.out.println("graph is not a bipartite");
    }
}
