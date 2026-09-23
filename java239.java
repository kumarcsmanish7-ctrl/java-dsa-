import java.util.*;
public class java239 {
    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int s,int d,int w){//constructor
            this.src =s;
            this.dest =d;
            this.wt =w;
        }
    }
    public static void createGraph(ArrayList<edge> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<edge>();
        }
        graph[0].add(new edge(0,2,2));

        graph[1].add(new edge(1,2,10));
        graph[1].add(new edge(1,3,-1));

        graph[2].add(new edge(2,0,2));
        graph[2].add(new edge(2,1,10));
        graph[2].add(new edge(2,3,-1));

        graph[3].add(new edge(3,1,0));
        graph[3].add(new edge(3,2,-1));

    }


    public static void bfs(ArrayList<edge>[] graph){//O(V+E)The one which is more controls time complexity
    // // remember this code 
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);//source =0 
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){//visit curr 
                System.out.print(curr+" ");
                vis[curr]=true;

                //add all the neightbours into the queue
                for(int i =0;i<graph[curr].size();i++){
                    edge e = graph[curr].get(i);
                    q.add(e.dest);

                }
            }
            
        }

    }
    //dfs -- O(V+E )
    public static void dfs(ArrayList<edge>[]graph ,int curr, boolean vis[] ){
        //visit
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0 ;i < graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }

    }

    public static boolean hasPath(ArrayList<edge>[] graph,int src,int dest,boolean vis[]){
        if(src ==dest){
            return true;
        }
        vis[src]= true;
        for(int i = 0 ;i < graph[src].size();i++){
            edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph,e.dest,dest,vis)){
                return true;
            }

        }
        return false;

    }
    public static void main(String args[]){
        int v=4;
        ArrayList<edge> graph[] = new ArrayList[v];//null->empty arrayListzzz
        //remember this  systax
        //it gives a warning because we cannot create a arraylist without defining its type 
        
        createGraph(graph);
        //print 2's neighbours
        for(int i =0;i<graph[2].size();i++){
            edge e =graph[2].get(i);
            System.out.println(e.dest+" , "+e.wt);
            
        }
        bfs(graph);
        System.out.println(" ");
        System.out.println("dfs: ");
        dfs(graph,0,new boolean[v]);
        System.out.println(hasPath(graph,0,5,new boolean[v]));
    }
}
