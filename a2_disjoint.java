// implementation of disjoint set using the union of rank and path compression

class disjoint {
    int[] parent; // tores the vertice's parent vertex
    int[] rank; // stores the ranks of parents
    int n;

    disjoint(int val) {
        parent = new int[val];
        rank = new int[val];
        n = val;
        initailSet();
    }

    void initailSet() { // initializing the parents of vertices with themselves
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int findp(int x) { // will return the parent of vertex
        if (parent[x] != x) {
            parent[x] = findp(parent[x]); // performing the path compression

        }

        return parent[x];

    }

    void union(int x, int y) {
        int xparent, yparent;
        xparent = findp(x); // finding the parent of x and y
        yparent = findp(y);

        if (xparent == yparent) // if boths parents are same means they are in same set i.e. they are already
                                // connect so we ignore this case
            return;

        if (rank[xparent] < rank[yparent]) { // if ranks of x parent is small then we will assign the parent of y as
                                             // parent x
            parent[xparent] = yparent; // we do not update rank because the rank of both the parents is same
        } else if (rank[yparent] < rank[xparent]) { // if rank of parent of y is less than rank of parent of x then we
                                                    // will make parent of x as the parent of y
            parent[yparent] = xparent;
        } else { // in this case rank of both the parent is same then we will assign any parents
                 // to any other vertix
            parent[yparent] = xparent;
            rank[xparent]++; // and here we also the update the rank whose is assigned as new parent
        }
    }

}

public class a2_disjoint {
    // vertexs are 0,1,2,3,4

    public static void main(String[] args) {

        int vertex = 5;       
        disjoint dis = new disjoint(vertex);

        dis.union(0, 1); // joining the 0 and 1
        dis.union(1, 2); // joining 1 and 2
        dis.union(3, 4); // joining 3 and 4
        
        if (dis.findp(0) == dis.findp(2)) // if both vertex parents are same it means they both are connected even
                                          // though they are not adjacent to each other
            System.out.println("yes 0 and 2 are connected");
        else
            System.out.println("no, 0 and 2 are not connected");

        if (dis.findp(1) == dis.findp(4))
            System.out.println("yes 1 and 4 are connected");
        else
            System.out.println("no, 1 and 4 are not connected");
    }

}
