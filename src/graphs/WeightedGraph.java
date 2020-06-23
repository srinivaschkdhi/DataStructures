package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class WeightedGraph {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int v;
        LinkedList<Edge>[] adjListArr;

        Graph(int v) {
            this.v = v;
            adjListArr = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adjListArr[i] = new LinkedList<>();
            }
        }
    }

    public static void addEdge(Graph graph, int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        graph.adjListArr[source].add(edge);
    }

    public static void printGraph(Graph graph) {
        for (int i = 0; i < graph.v; i++) {
            LinkedList<Edge> list = graph.adjListArr[i];

            for (int j = 0; j < list.size(); j++) {
                System.out.println("vertex-" + i + "is connected to " +
                        list.get(j).destination + " with weight " + list.get(j).weight);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 2, 3);
        addEdge(graph, 1, 3, 2);
        addEdge(graph, 1, 2, 5);
        addEdge(graph, 2, 3, 7);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 0, 4);
        addEdge(graph, 4, 1, 4);
        addEdge(graph, 4, 5, 6);

        printGraph(graph);
    }

    public static void topologicalSortUtil(Graph graph, int v, boolean[] visited, Stack stack) {
        visited[v] = true;

        Iterator<Edge> negihs = graph.adjListArr[v].listIterator();

        while (negihs.hasNext()) {
            Edge edge = negihs.next();
            int dest = edge.destination;
            if (visited[dest] == false) {
                topologicalSortUtil(graph, dest, visited, stack);
            }
        }

        stack.push(v);
    }

    public static Integer[] topologicalSort(Graph graph) {
        Stack stack = new Stack();

        boolean[] visited = new boolean[graph.v];


        for (int i = 0; i < graph.v; i++) {
            if (visited[i] == false)
                topologicalSortUtil(graph, i, visited, stack);
        }

        Integer[] topSort = new Integer[graph.v];
        int i = 0;
        while (!stack.isEmpty()) {
            Integer vertext = (Integer) stack.pop();
            topSort[i++] = vertext;
            System.out.print(vertext + "->");
        }

        return topSort;
    }
}
