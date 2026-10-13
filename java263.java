import java.util.*;
public class java263 {//strongly connected component



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
        
        graph[0].add(new edge(0,2));
        graph[0].add(new edge(0,3));
        

        graph[1].add(new edge(1,0));

        
        graph[2].add(new edge(2,1));
        graph[3].add(new edge(3,4));

    }

    public static void topSort(ArrayList<edge> graph[], int curr , boolean vis[] , Stack<Integer> s){
        vis[curr] =true;
        for(int i = 0 ; i< graph[curr].size();i++){
            edge e  = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis,s);
                
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<edge> graph[] , int curr , boolean vis[]){
        vis[curr] =true;
        System.out.print(curr+ " ");//we have to print the visiting node to say its a strongly connected component
        for(int i = 0 ; i< graph[curr].size();i++){
            edge e  = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
                
            }
        }
    }
    public static void kosaraju(ArrayList<edge> graph[], int v){
        //step1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];
        for(int i = 0 ; i<v ; i++){
            if(!vis[i]){
                topSort(graph, i , vis, s);
            }
        }

        //step2 - transpose
        ArrayList<edge> transpose[] = new ArrayList[v];
        for(int i =0;i<graph.length;i++){
            vis[i]= false;
            transpose[i] = new ArrayList<edge>();//initialize transpose graph with the empty arraylist 
        }
        for(int i = 0 ;i<v;i++){//for every vertex then go to every edge 
            for(int j = 0 ;j<graph[i].size();j++){
                edge e = graph[i].get(j);// we have to reverse this e.src->e.dest to e.dest->e.src
                transpose[e.dest].add(new edge(e.dest,e.src));//imp - reversed the edge
            }
        }

        //step 3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                System.out.print("SCC -> ");
                dfs(transpose,curr, vis);//call dfs on transpose graph
                System.out.println();
            }
        }
    }

    public static void main(String args[]){        
       int V = 6; 
       ArrayList<edge> graph[] = new ArrayList[V];
       createGraph(graph);
       kosaraju(graph,V);
       
      
    }
}
