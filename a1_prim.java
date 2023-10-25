// prims algo is used to find the minimum spanning tree (mst)
// mst is type of spanning tree whose is cost is minimum among all the possible spanning tree

class prim {
    static final int N = 5; // this number of nertices in our graph

    void printMst(int[] parent, int[][] g) {
        int cost=0;

        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i + " = " + g[i][parent[i]]);
            cost+=g[i][parent[i]];
        }

        System.out.println("cost of MST is = "+cost);
    }

    int minKey(int key[], boolean mst[]) { // this will return that node(vertex) whose cost is minimum and whose mst is false 
        int minInd = -1, minval = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (key[i] < minval && mst[i] == false) {
                minval = key[i];
                minInd = i;
            }
        }

        return minInd;

    }

    void mst(int[][] g) {
        int key[] = new int[N];         // this will store the costs
        boolean mst[] = new boolean[N]; // this will keep track which node is included in mst 
        int parent[] = new int[N];      // this store the route of mst i.e. our answer

        for (int i = 0; i < N; i++) { // initailizing  
            key[i] = Integer.MAX_VALUE;  //the key array with infinite values
            mst[i] = false;              //and mst with false values 

        }

        key[0] = 0;   // taking the first node(vertex) as root whose cost to itself will be zero 
        
        parent[0] = -1;  // there is no parent of the root node so its value will be -1

        for (int count = 0; count < N; count++) {

            int u = minKey(key, mst); // fetching the next node whose cost is minimum and is not yet inluded in mst i.e. whos mst is false 
            mst[u] = true;            // marking the new selected node as true and including it in mst 

           

            for (int v = 0; v < N; v++) { // now finding the adjacent nodes of u (newly included in mst)
                if (g[u][v] != 0 && mst[v] == false && g[u][v] < key[v]) { // the node  is adjacent to the u node whose g[u][v] is not equal to zero
                    // and if that adjacent node's mst is false and also that node's cost is smaller than previous cost , then we will update the key and parent 

                    key[v] = g[u][v]; // updating the new minimum cost with respect to u (newly added mst node)
                    parent[v] = u;    // and updating the parent as u

                }
            }
        }

        printMst(parent, g);

    }
}

public class a1_prim {
    public static void main(String[] args) {
        int graph[][]=new int[][]{{0,2,0,6,0},
                                   {2,0,3,8,5},
                                   {0,3,0,0,7},
                                   {6,8,0,0,0},
                                   {0,5,7,0,0}

        };

        prim p=new prim();
        p.mst(graph);
    }

}
