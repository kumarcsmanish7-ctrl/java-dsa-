import java.util.*;
public class java245 {//detect cycles for directed graph



    static class edge{//we changed here 
        int src;
        int dest;
        int wt;
        
        public edge(int s,int d,int wt){//constructor
            this.src =s;
            this.dest =d;
            this.wt =wt;
            
        }
    }
    public static void createGraph(ArrayList<edge> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<edge>();
        }
        
        graph[0].add(new edge(0,1,2));
        graph[0].add(new edge(0,2,4));

        graph[1].add(new edge(1,3,7));
        graph[1].add(new edge(1,2,1));

        graph[2].add(new edge(2,4,3));        

        graph[3].add(new edge(3,5,1));

        
        graph[4].add(new edge(4,3,2));
        graph[4].add(new edge(4,5,5));
  

    }

// use comparible interface in the pair to make it sorted according to the dist
    static class Pair implements Comparable<Pair>{
        int n ; 
        int path;
        public Pair(int n , int path){
            this.n = n ; 
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;// the one which is smaller is returned first by the priority queue
            // path based sorting for my pairs 
        }
    }

    public static void dijkstra(ArrayList<edge> graph[],int src){
        int dist[] = new int[graph.length];// dist[i] -> src to i 
        for(int i = 0 ; i<graph.length;i++){
            if(i != src){// source to source distance = 0 for rest +infinity
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        // loop for bfs
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                //update neighbour distance 
                for(int i =0 ; i<graph[curr.n].size();i++){// we are using curr.n because its a pair
                    edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u]+wt<dist[v]){
                        dist[v] =dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));//push the new pair to priority queue 
                    }
                }
            }
        }
        // print all source to destination's shortest path
        for(int i = 0 ; i<dist.length;i++){
            System.out.print(dist[i]+" ");

        }
        System.out.println();

    }
   
    public static void main(String args[]){        
       int V = 6; 
       ArrayList<edge> graph[] = new ArrayList[V];
       createGraph(graph);
       
       int src = 0 ; 
       dijkstra(graph,src);
       
      
    }
}
