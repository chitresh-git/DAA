import java.util.ArrayList;
import java.util.List;


public class j61_articulation {
    
    static int timer=1;
    static List<Integer> l=new ArrayList<>();

    static void dfs(int node ,int parent, int vis[], int time[],int low[],int e[][]){
      vis[node]=1;

      time[node]=low[node]=timer;
      timer++;
      int child=0;
      for(int i : e[node]){
        if(i==parent) continue;
          if(vis[i]==0){
              dfs(i,node, vis, time, low, e);
              low[node]=Math.min(low[i], low[node]);
              
              if(low[i]>=time[node] && parent!=-1 && !l.contains(node))
              l.add(node);
              
              child++;

        }
        else{
            low[node]=Math.min(time[i], low[node]);
        }
      }
      if(child>1 && parent==-1 && !l.contains(node))
      l.add(node);

    }

    public static void main(String[] args) {
        int v=7;

        int time[]=new int[v];
        int low[]=new int[v];
        int vis[]=new int[v];

        int e[][]={{1,2,3},{1},{0,3,4,5},{2,0},{2,6},{2,6},{4,5}};
         
        for(int i=0;i<v;i++){
            if(vis[i]==0)
            dfs(0, -1, vis, time, low, e);
        }

        System.out.println(l.size());
        for(int i:l)
        System.out.println(i);
    }
}
