import java.util.*;
public class java265 {//articulation point



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

        graph[4].add(new edge(4,3));

    }
    // main code is in this dfs function 
    //O(V+E)
    public static void dfs(ArrayList<edge>graph[],int curr, int par,
                            int dt[],int low[],int time, boolean vis[],boolean ap[]){
            
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        //track children
        int children = 0 ;
        for(int i = 0 ;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            int neigh = e.dest;
            
            if(par ==neigh){
                continue;//ignore
            }
            else if(vis[neigh]){
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
            //neighbour not visited 
            else{
                dfs(graph,neigh,curr,dt,low,time,vis,ap);//curr->neigh,par->curr
                low[curr] = Math.min(low[curr],low[neigh]);
                if(par!=-1 && dt[curr]<= low[curr]){
                    // System.out.println("Ap: "+curr);
                    //instead of printing 
                    ap[curr] = true;
                }
                children++;
            }
        }
        //after loop completion check condition 1 
        if(par==-1 && children>1){
            // System.out.println("Ap: "+ curr);
            ap[curr]=true;
        }


        }

    public static void getAp(ArrayList<edge> graph[], int V){
        int dt[] = new int[V];
        int low[] =new int[V];
        int time = 0 ;
        boolean vis[] = new boolean[V];
        //tarjan algorithm can print the same articulation point multiple times so we make a articulationpoint array to track this similar to visited array
        boolean ap[] = new boolean[V];

        for(int i = 0;i<V;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,time,vis,ap);
            }
        }
        for(int i = 0;i<V;i++){
            if(ap[i]){
                System.out.println("Ap: "+i);
            }
        }

    }
    public static void main(String args[]){        
       int V = 6; 
       ArrayList<edge> graph[] = new ArrayList[V];
       createGraph(graph);
       getAp(graph,V);

       
       
      
    }
}
