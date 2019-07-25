package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    static class Graph{
        int V;
        LinkedList<Integer>[] adjListArray;

        public Graph(int v) {
            this.V = v;
            adjListArray = new LinkedList[v];

            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }
    }

    static void addEdge(Graph graph,int src,int dest){
        graph.adjListArray[src].add(dest);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        addEdge(graph,0, 1);
        addEdge(graph,0, 2);
        addEdge(graph,1, 2);
        addEdge(graph,2, 0);
        addEdge(graph,2, 3);
        addEdge(graph,3, 3);
        BFS(graph,2);
    }

    private static void BFS(Graph graph, int s) {
        boolean[] visited = new boolean[graph.V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        while(!queue.isEmpty()){
            s = queue.poll();
            System.out.println("s = " + s);

            Iterator<Integer> i = graph.adjListArray[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(visited[n]==false){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }
}
