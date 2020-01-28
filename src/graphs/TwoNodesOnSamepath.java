package graphs;

import java.util.Iterator;
import java.util.LinkedList;

import static graphs.CycleinDirectedGraph.addEdge;

public class TwoNodesOnSamepath {

    static class Graph{
        int V;
        LinkedList<Integer>[] adjListArray;

        Graph(int V){
            this.V = V;
            adjListArray = new LinkedList[V + 1] ;

            for(int i =0;i<V +1;i++){
                adjListArray[i] = new LinkedList<>();
            }
        }
    }

     static void addEdge(Graph graph,int src,int dest){
        graph.adjListArray[src].add(dest);
    }


    static int timer = 0;
    static boolean[] visited;
    static int[] inTime;
    static int[] outTime;

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        visited = new boolean[10];
        inTime = new int[10];
        outTime = new int[10];

        addEdge(graph,1,2);
        addEdge(graph,1,3);
        addEdge(graph,3,6);
        addEdge(graph,2,4);
        addEdge(graph,2,5);
        addEdge(graph,5,7);
        addEdge(graph,5,8);
        addEdge(graph,5,9);
        dfs(graph,1);

        boolean query = query(5, 1);
        boolean query1 = query(9, 2);
        boolean query2 = query(2, 6);
        System.out.println("query2 = " + query2);
        System.out.println("query1 = " + query1);
        System.out.println("query = " + query);
    }

    static boolean query(int u, int v) {
        return (inTime[u] < inTime[v] && outTime[u] > outTime[v]) || (inTime[v] < inTime[u] && outTime[v] > outTime[u]);
    }

    static void dfs(Graph graph, int v) {
        visited[v] = true;
        ++timer;
        inTime[v] = timer;

        Iterator<Integer> neighs = graph.adjListArray[v].listIterator();
        while (neighs.hasNext()) {
            int neigh = neighs.next();
            if (visited[neigh] == false)
                dfs(graph, neigh);
        }

        ++timer;
        outTime[v] = timer;
    }
}
