public class a8_djikistras {
    // SINGLE SOURCE SHORTEST PATH  using dijkistras method (greedy method)
    static final int V = 9;

   static int minDist(boolean[] set, int[] dist) { // will return minimum distance from source to that node which is not included in resultant set

        int min = Integer.MAX_VALUE;
        int minInd = -1;

        for (int i = 0; i < V; i++) {
            if (set[i] ==false && dist[i] <= min) {
                min = dist[i];
                minInd = i;
            }
        }

        return minInd;
    }

    static void shortPaths(int graph[][], int source) {

        int dist[] = new int[V]; // will store distances 
        boolean set[] = new boolean[V]; // store which node is added to our set
        // set[i] will true if vertex is inluded in our shortest path tree

        for (int i = 0; i < V; i++) { // initializes all the distances to infinity and set to false
            dist[i] = Integer.MAX_VALUE;
            set[i] = false;
        }

        dist[source]=0;// the distance of source to itself is 0 
        
        for (int k = 0; k < V - 1; k++) {

            int u = minDist(set, dist);// get the index of node which has minimum distance and not yet included in set 
            set[u] = true;          // add that node into set 
           
            // update distance of adjacent nodes of node u only if

            // node u is not included in set
            // there is path exist from node u i.e. they must be connected by edge
            // weight of path from src to v through u is smaller than current value of dist[v]
                
            
            for (int v = 0; v < V; v++) {

                if (!set[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        
        for(int i=0;i<V;i++){
            System.out.println(" distance from source "+source+" to node "+i+ " is : "+dist[i]);

            
        }
    }

    public static void main(String[] args) {
        int graph[][]={
                            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                            { 0, 0, 2, 0, 0, 0, 6, 7, 0}
    };

             shortPaths(graph,0);
}
}
