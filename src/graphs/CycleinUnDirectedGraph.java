package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class CycleinUnDirectedGraph {
    static class Graph {
        int V;

        LinkedList<Integer>[] adjListArray;

        Graph(int V) {
            this.V = V;
            adjListArray = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<>();
            }


        }
    }

    static void addEdge(CycleinUnDirectedGraph.Graph graph, int src, int dest) {
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }

    public static void main(String[] args) {
        CycleinUnDirectedGraph.Graph graph = new CycleinUnDirectedGraph.Graph(5);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph,2,3);
        addEdge(graph,2,4);
        addEdge(graph,3,4);
        boolean cyclePresent = detectCycle(graph);
        System.out.println("cyclePresent = " + cyclePresent);
    }

    private static boolean detectCycle(Graph graph) {
        boolean[] visited = new boolean[graph.V];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        visited[0] = true;
        Stack<Integer> parent = new Stack<>();
        parent.push(-1);

        while(!stack.isEmpty()){
            int v = stack.pop();
            int par = parent.pop();

            Iterator<Integer> neighs = graph.adjListArray[v].listIterator();
            while(neighs.hasNext()){
                int u = neighs.next();
                if(visited[u] == false){
                    visited[u] = true;
                    stack.push(u);
                    parent.push(v);
                }else{
                    if(u != par)// v for vertex v , if exists adjacent vertex u , if u is visited and if u is not parent of v
                        return true;
                }
            }
        }
        return false;
    }

}
