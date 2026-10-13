import java.util.*;
public class java264 {//tarjan algorithm



    static class edge{//we changed here 
        int src;
        int dest;
        
        public edge(int s,int d){//constructor
            this.src =s;
            this.dest =d;
            
        }
    }
    public static void createGraph(ArrayList<edge> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<edge>();
        }
        
        graph[0].add(new edge(0,1));
        graph[0].add(new edge(0,2));
        graph[0].add(new edge(0,3));

        graph[1].add(new edge(1,0));
        graph[1].add(new edge(1,2));
        
        graph[2].add(new edge(2,0));
        graph[2].add(new edge(2,1));

        graph[3].add(new edge(3,0));
        graph[3].add(new edge(3,4));
        graph[3].add(new edge(3,5));

        graph[4].add(new edge(4,3));
        graph[4].add(new edge(4,5));

        graph[5].add(new edge(5,3));
        graph[5].add(new edge(5,4));

    }

    public static void dfs(ArrayList<edge> graph[] ,int curr , int par, int dt[], int low[], 
        boolean vis[],int time ){
            vis[curr] =true;
            dt[curr] = low[curr]=++time;
            for(int i = 0 ; i<graph[curr].size();i++){
                edge e = graph[curr].get(i);//e.src ----e.dest

                int neigh = e.dest;
                if(neigh == par){
                    continue;//ignore - do nothing
                }
                else if(!vis[neigh]){
                    //curr->neigh , par->curr
                    dfs(graph,neigh,curr,dt,low,vis,time);
                    low[curr] = Math.min(low[curr],low[neigh]);

                    //bridge condition 
                    if(dt[curr]<low[neigh]){
                        System.out.println("Bridge"+ curr+"--->"+neigh);
                    }
                }
                else{// neighbour is already visited 

                    //important
                    low[curr] = Math.min(low[curr],dt[neigh]);// remember to write dt[neigh]   its not low[neigh]
                }
            }

    }

    public static void tarjanBridge(ArrayList<edge> graph[], int V){
        int dt[] = new int[V];//discovery time 
        int low[] = new int[V];
        int time = 0 ; 
        boolean vis[] = new boolean[V];

        for(int i = 0 ; i<V;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,vis,time);//every work is done by this dfs function only
            }
        }
    }
    
    public static void main(String args[]){        
       int V = 6; 
       ArrayList<edge> graph[] = new ArrayList[V];
       createGraph(graph);
       tarjanBridge(graph,V);
       
      
    }
}
