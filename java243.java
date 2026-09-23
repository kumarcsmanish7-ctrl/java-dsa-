import java.util.*;
public class java243 {//detect cycles for directed graph



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
        

        graph[2].add(new edge(2,3));
        

        graph[3].add(new edge(3,1));

        
        graph[4].add(new edge(4,0));
        graph[4].add(new edge(4,1));

        graph[5].add(new edge(5,0));
        graph[5].add(new edge(5,2));  

    }

    public static void topSort(ArrayList<edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();// inbuilt stack of java
        for(int i = 0 ;i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph, i , vis, s);// modified dfs function 
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }

    }
    public static void topSortUtil(ArrayList<edge>[] graph,int curr, boolean[] vis, Stack s){
        vis[curr]= true;
        for(int i=0;i<graph[curr].size();i++){
            edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph,e.dest, vis, s);
        }
    }
    s.push(curr);// by this the elements will get arranged in topological order 

    }

    public static void calindeg(ArrayList<edge> graph[],int[] indeg){
        for(int i = 0 ;i < graph.length;i++){
            int v=i;
            for(int j = 0 ; j<graph[v].size();j++){
                edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    
    //topological sort using bfs , kahn's algorithm
    public static void topSortbfs(ArrayList<edge> graph[]){
        int indeg[] = new int[graph.length];
        calindeg(graph,indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");//printing the topological sorting

            //making neighbours indegree -1 
            for(int i = 0 ; i<graph[curr].size();i++){
                edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]){        
       int V = 6; 
       ArrayList<edge> graph[] = new ArrayList[V];
       createGraph(graph);
       topSort(graph);
       System.out.println();
       topSortbfs(graph);
       
      
    }
}
