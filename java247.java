import java.util.*;
public class java247{//prims algorithm or mst 



    static class edge{
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
        
        graph[0].add(new edge(0,1,10));
        graph[0].add(new edge(0,2,15));
        graph[0].add(new edge(0,3,30));

        graph[1].add(new edge(1,0,10));
        graph[1].add(new edge(1,3,40));
        

        graph[2].add(new edge(2,0,15));        
        graph[2].add(new edge(2,3,50));

        graph[3].add(new edge(3,1,40));
        graph[3].add(new edge(3,2,50));
       
  

    }

    //pair class 
    static class Pair implements Comparable<Pair>{//revise greedy for comparable 
        int v;
        int cost ; 
        public Pair(int v , int cost){// we are making a constructor
            this.v = v;
            this.cost =cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;//asending 
        }
    }
    public static void prims(ArrayList<edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();// it is a min heap internally
        pq.add(new Pair(0,0));
        int finalCost = 0 ; // mst cost / total min weight or we can make a AL<Edge> to store the answer 

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalCost+= curr.cost;
            }
            for(int i = 0 ; i<graph[curr.v].size();i++){
                edge e = graph[curr.v].get(i);
                pq.add(new Pair(e.dest, e.wt));//add the neightbours 
            }
        }
        System.out.print("minimum cost of mst = "+finalCost);

    }


     public static void createGraph2(ArrayList<edge> graph){        
        
        graph.add(new edge(0,1,2));
        graph.add(new edge(0,2,4));

        graph.add(new edge(1,3,-4));
        

        graph.add(new edge(2,3,2));        

        graph.add(new edge(3,4,4));

        
        graph.add(new edge(4,1,-1));
        
  

    }    public static void main(String args[]){        
       int V= 5; 
       ArrayList<edge> graph[] = new ArrayList[V];
       createGraph(graph);
       
       prims(graph);
       
      
    }
}
