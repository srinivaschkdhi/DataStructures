package graphs;

import java.util.*;

public class CycleinDirectedGraph {
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

    static void addEdge(Graph graph, int src, int dest) {
        graph.adjListArray[src].add(dest);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 0);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 3);

        boolean cyclePresent = detectCycle(graph);
        System.out.println("cyclePresent = " + cyclePresent);
    }

    public static boolean detectCycle(Graph graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> ancestorNodes = new HashSet<>();
        boolean[] visited = new boolean[graph.V];

        visited[2] = true;
        stack.push(2);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.print(v + "--->");
            ancestorNodes.add(v);

            Iterator<Integer> neighs = graph.adjListArray[v].listIterator();
            while (neighs.hasNext()) {
                int i = neighs.next();
                System.out.println("checking if "+i+"is back node");
                //modified dfs
                if(ancestorNodes.contains(i))
                    return true;

                if (visited[i] == false) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        return false;
    }

}
