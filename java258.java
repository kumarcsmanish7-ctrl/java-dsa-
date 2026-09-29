import java.util.*;
public class java258 {//Kruskal algorithm

    static class Edge implements Comparable<Edge>{//weight ke basis per sorting 
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src =s;
            this.dest =d;
            this.wt =w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }

    }
    static void createGraph(ArrayList<Edge> edges){//here graph is creaded with edges
        //edges
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    static int n = 4; // n is no of vertices 
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i = 0 ;i<n;i++){
            par[i]=i;
        }
    }

    public static int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x] =find(par[x]);
    }
    public static void union(int a ,int b){
        int parA = find(a);
        int parB =find(b);

    }
    public static void krushkalsMst(ArrayList<Edge> edges, int V){
        init();
        //sort the edges of the graph 
        Collections.sort(edges);//we get the sorting in ascending order 
        int mstCost = 0 ;
        int count = 0 ;//no of edges included 
        for(int i=0;count<V-1;i++){// we can write i<edges.length for this count<V-1, but the loop would have run for some extra time
            Edge e = edges.get(i);
            // src, dest, wt
            //check the source and parant have same parent if same parent then there is a cycle
            int parA = find(e.src);
            int parB = find(e.dest);
            if(parA != parB){// if both parents are not same then take union of it 
                union(e.src,e.dest);
                mstCost += e.wt;
                count++;
            }


        }
        System.out.println(mstCost);

    }
    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        krushkalsMst(edges,V);
    }
}
