package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    static class Graph{
        int V;
        LinkedList<Integer>[] adjListArray;

        Graph(int v){
            this.V = v;
            adjListArray = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }
    }

    static void addEdge(Graph graph,int src,int dest){
        graph.adjListArray[src].add(dest);
    }

    static void topologicalSortUtil(Graph graph,int v, boolean[] visited, Stack stack){
        visited[v] = true;

        Iterator<Integer> negihs = graph.adjListArray[v].listIterator();

        while(negihs.hasNext()){
            int neigh = negihs.next();
            if(visited[neigh] == false){
                topologicalSortUtil(graph,neigh,visited,stack);
            }
        }

        stack.push(v);
    }

    static Integer[] topologicalSort(Graph graph){
        Stack stack = new Stack();

        boolean[] visited = new boolean[graph.V];


        for (int i = 0; i < graph.V; i++) {
            if(visited[i] == false)
                topologicalSortUtil(graph,i,visited,stack);
        }

        Integer[] topSort = new Integer[graph.V];
        int i = 0;
        while(!stack.isEmpty()){
            Integer vertext = (Integer) stack.pop();
            topSort[i++] = vertext;
            System.out.print(vertext + "->");
        }

        return topSort;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        addEdge(graph,5,2);
        addEdge(graph,5,0);
        addEdge(graph,4,0);
        addEdge(graph,4,1);
        addEdge(graph,2,3);
        addEdge(graph,3,1);

        System.out.println("Following is a Topological sort of given graph");

        topologicalSort(graph);


    }
}
