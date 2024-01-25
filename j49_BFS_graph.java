import java.util.LinkedList;
import java.util.Queue;

// BREADTH FIRST SEARCH in graphs 

public class j49_BFS_graph {

    static void bfs(int e[][], int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v]; // true if node is visited

        q.add(0); // adding the first node 0
        visited[0] = true; // marking added node as true(visited)

        while (!q.isEmpty()) {

            int node = q.poll(); // removing the front node of queue storing it in temporary variable

            System.out.println(node); // printing that front node

            for (int i : e[node]) { // adding all the nodes connected with front node if connected node is unvisited
                                    // (if false ) , marking them as true
                if (visited[i] != true) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        int e[][] = { { 3 }, { 2, 3, 4 }, { 1 }, { 0, 1 }, { 2 } }; // adjacency list 
        int v = 5;

        bfs(e, v);
    }

}
