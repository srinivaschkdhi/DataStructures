package graphs;

import java.util.*;

public class SingleSourceShortestPath {
    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph();

        WeightedGraph.Graph graph = new WeightedGraph.Graph(8);
        WeightedGraph.addEdge(graph, 0, 1, 3);
        WeightedGraph.addEdge(graph, 0, 2, 6);

        WeightedGraph.addEdge(graph, 1, 2, 4);
        WeightedGraph.addEdge(graph, 1, 3, 4);
        WeightedGraph.addEdge(graph, 1, 4, 11);

        WeightedGraph.addEdge(graph, 2, 3, 8);
        WeightedGraph.addEdge(graph, 2, 6, 11);

        WeightedGraph.addEdge(graph, 3, 5, 5);
        WeightedGraph.addEdge(graph, 3, 6, 2);

        WeightedGraph.addEdge(graph, 4, 7, 9);

        WeightedGraph.addEdge(graph, 5, 7, 1);

        WeightedGraph.addEdge(graph, 6, 7, 2);


        TopologicalSort.Graph topGraph = new TopologicalSort.Graph(8);
        TopologicalSort.addEdge(topGraph, 0, 1);
        TopologicalSort.addEdge(topGraph, 0, 2);

        TopologicalSort.addEdge(topGraph, 1, 2);
        TopologicalSort.addEdge(topGraph, 1, 3);
        TopologicalSort.addEdge(topGraph, 1, 4);

        TopologicalSort.addEdge(topGraph, 2, 3);
        TopologicalSort.addEdge(topGraph, 2, 6);

        TopologicalSort.addEdge(topGraph, 3, 4);
        TopologicalSort.addEdge(topGraph, 3, 5);
        TopologicalSort.addEdge(topGraph, 3, 6);

        TopologicalSort.addEdge(topGraph, 4, 7);

        TopologicalSort.addEdge(topGraph, 5, 7);

        TopologicalSort.addEdge(topGraph, 6, 7);


        Integer[] vertices = TopologicalSort.topologicalSort(topGraph);

        Integer[] dist = new Integer[graph.v];
        dist[0] = 0;

        for (Integer vertext : vertices) {
            int nodeIntex =  vertext;
            if (dist[nodeIntex] != null) {
                ListIterator<WeightedGraph.Edge> edgeListIterator = graph.adjListArr[nodeIntex].listIterator();

                while (edgeListIterator.hasNext()) {
                    WeightedGraph.Edge edge = edgeListIterator.next();
                    int source = nodeIntex;
                    int destination = edge.destination;
                    int weight = edge.weight;

                    int newDist = dist[source] + weight;

                    if (dist[destination] == null)
                        dist[destination] = newDist;
                    else
                        dist[destination] = Math.min(newDist, dist[destination]);

                }
            }
        }

        System.out.println(Arrays.toString(dist));

    }
}
