import java.util.*;
public class java246{//dbellmon ford 



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
        
        graph[0].add(new edge(0,1,2));
        graph[0].add(new edge(0,2,4));

        graph[1].add(new edge(1,3,-4));
        

        graph[2].add(new edge(2,3,2));        

        graph[3].add(new edge(3,4,4));

        
        graph[4].add(new edge(4,1,-1));
        
  

    }

     public static void createGraph2(ArrayList<edge> graph){
        
        
        graph.add(new edge(0,1,2));
        graph.add(new edge(0,2,4));

        graph.add(new edge(1,3,-4));
        

        graph.add(new edge(2,3,2));        

        graph.add(new edge(3,4,4));

        
        graph.add(new edge(4,1,-1));
        
  

    }

    public static void bellmonFord(ArrayList<edge> graph[], int src ){
        int dist[] = new int[graph.length];
        for(int i = 0 ; i<dist.length;i++){
            if(i!= src){
                dist[i]= Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        //total time complexity  - O(V*E)
        //algo- O(V)
        for(int i = 0 ; i<V-1; i++){
            //edges -O(E) === even after using 2 or 3 loops 
            for(int j = 0 ; j<graph.length;j++){
                for(int k  = 0 ; k<graph[j].size();k++){
                    edge e = graph[j].get(k);
                    //u,v,wt
                    int u = e.src; 
                    int v = e.dest;
                    int wt = e.wt;

                    //relaxation
                    if(dist[u]!= Integer.MAX_VALUE  && dist[u]+wt< dist[v]){
                        // THIS CONDITION dist[u]!= Integer.MAX_VALUE  IS USED because in java +infinity + something its make negative values not +infininty
                        dist[v] = dist[u]+wt;
                    }
                }
            }

        }
        //print 
        for(int i = 0 ; i<dist.length;i++){
            System.out.print(dist[i]+ " ");
        }
        System.out.println();
    }
   

    public static void bellmonFord2(ArrayList<edge> graph, int src ,int V){
        int dist[] = new int[V];
        for(int i = 0 ; i<dist.length;i++){
            if(i!= src){
                dist[i]= Integer.MAX_VALUE;
            }
        }
        

      //this also take O(V*E)
        for(int i = 0 ; i<V-1; i++){//this loop takes O(V)
            //edges -O(E) === even after using 2 or 3 loops 
            for(int j = 0 ; j<graph.size();j++){//O(E)
                    edge e = graph.get(j);
                    //u,v,wt
                    int u = e.src; 
                    int v = e.dest;
                    int wt = e.wt;

                    //relaxation
                    if(dist[u]!= Integer.MAX_VALUE  && dist[u]+wt< dist[v]){
                        // THIS CONDITION dist[u]!= Integer.MAX_VALUE  IS USED because in java +infinity + something its make negative values not +infininty
                        dist[v] = dist[u]+wt;
                    }
                }
                
            

        }
        //print 
        for(int i = 0 ; i<dist.length;i++){
            System.out.print(dist[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String args[]){        
       int V= 5; 
       ArrayList<edge> graph[] = new ArrayList[V];
       createGraph(graph);
       
       bellmonFord(graph,0); 
     

       ArrayList<edge> graph2 = new ArrayList<>();
       createGraph2(graph2 );
       bellmonFord2(graph2,0,V);
       
      
    }
}
