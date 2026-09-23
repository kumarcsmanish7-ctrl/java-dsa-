import java.util.*;
public class java241 {
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

    
    


    public static boolean detectCycle(ArrayList<edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0 ;i < graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true ;
                    //cycle exists in one of the part 
                }
            }
        }return false;
    }
    public static boolean detectCycleUtil(ArrayList<edge>[] graph, boolean vis[] , int curr , int par){
        vis[curr]= true; 
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            //case 3 
            if(!vis[e.dest] ){//curr becomes neighbour and parent becomes curr
                if(detectCycleUtil(graph,vis, e.dest,curr)){//donot write in one if condition because it calls new stack call, so it make the ans wrong if done in one if statement
                return true ;
                }
            }
            //case 1 
            else if(vis[e.dest]&& e.dest != par){
                return true ;
            }
            //case 2 -> do nothing->continue // it is automatically done 

            }
            return false ;
    }


    public static boolean isBipartite(ArrayList<edge>[] graph){
        int color[] = new int[graph.length];
        for(int i =0;i<color.length;i++){
            color[i]=-1;//no color
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){//bfs
                q.add(i);
                color[i]=0; // yellow
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j = 0 ;j<graph[curr].size();j++){
                        edge e = graph[curr].get(j); // e.dest
                        

                        //no color 
                        if(color[e.dest]==-1){
                            int nextcolor = color[curr]==0? 1: 0 ;
                            color[e.dest] = nextcolor;
                            q.add(e.dest);
                        }

                        //same color neighbour
                        else if(color[e.dest]==color[curr]){
                            return false ;// NOT BIPARTITE
                        }
                    }
                }
            }
        }return true;
    }
    public static void main(String args[]){
        /*
            0-------3
           /|       |
          / |       |
        1   |       4
          \ |
           \|
            2

        */
       int V = 5; 
       ArrayList<edge> graph[] = new ArrayList[V];
       createGraph(graph);

       System.out.println(detectCycle(graph));
       System.out.println(isBipartite(graph));
    }
}
