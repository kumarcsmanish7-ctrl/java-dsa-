import java.util.*;
public class java255 {//cheapest flights within k stops 
    static  class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d, int wt){
            this.src = s; 
            this.dest = d;
            this.wt = wt;
        }
    }
    public static void createGraph(int[][] flights, ArrayList<Edge> graph[]){
        // we have to initialize with a arraylist as it is all empty inside graph
        for(int i = 0 ; i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        //traverse the flight and make the edge where it exists 
        for(int i = 0 ; i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            Edge e = new Edge(src,dest,wt);

            //in our graph implementation of graph using adjacency list we store the destination in the source index
            graph[src].add(e);
        }
    }

    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int c, int k){
            this.v = v;
            this.cost = c;
            this.stops= k ;
        }
    }

    public static int cheapestFlight(int n , int flights[][] , int src, int dest, int k ){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        //we have to implement dijkstra modified 
        int dist[] = new int[n];// to store the distance from the  src to that node 
        for(int i = 0;i<n;i++){// we are initializing  dist, if not source initialize the dist with infinity
            if(i!= src){
                dist[i]=Integer.MAX_VALUE;                
            }
        }
        // make the queue that stores the information of (vertex,cost , stops)
        Queue<Info> q = new LinkedList<>();
        //adding src to the queue
        q.add(new Info(0,0,0));
        while(!q.isEmpty()){
            Info curr = q.remove();
            //remove from queue and check curr's stop is greater than the allowed stops "k" 
            if(curr.stops>k){
                break;
            }
            //we have to update for neightbours 
            for(int i  = 0 ;i<graph[curr.v].size();i++){
                Edge e = graph[curr.v].get(i);// taking the edges 
                int u = e.src;
                int v = e.dest;
                int wt =e.wt;
                //relaxation step

                // if(dist[u]!= Integer.MAX_VALUE && dist[u]+wt < dist[v]&& curr.stops <=k){
                //     dist[v]=dist[u]+wt; // do not use this 
                if(curr.cost+wt < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost+wt;

                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }
        // at last check the dest distance 
        if(dist[dest]== Integer.MAX_VALUE)return -1;
        else return dist[dest];
    }
    public static void main(String args[]){
        int n = 4; 
        int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1; 
        System.out.println(cheapestFlight(n,flights,src,dst,k));
    }
}
