package graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BellmanFordAdjacenyList {
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

    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void addEdge(Graph graph, int source, int destination, int weight) {
        graph.adjListArr[source].add(new Edge(source, destination, weight));
    }

    public static double[] bellmanFord(Graph graph, int start) {
        double[] dist = new double[graph.v];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[start] = 0;

        for(int k = 0; k < graph.v - 1;k++){
            for (int i = 0; i < graph.v; i++) {
                Iterator<Edge> edgesFromThisSource = graph.adjListArr[i].listIterator();
                while (edgesFromThisSource.hasNext()) {
                    Edge edge = edgesFromThisSource.next();

                    int source = edge.source;
                    int destination = edge.destination;
                    int weight = edge.weight;

                    double newDist = dist[source] + weight;

                    dist[destination] = Math.min(newDist, dist[destination]);

                }
            }
        }

        for(int k = 0;k < graph.v - 1;k++){
            for (int i = 0; i < graph.v; i++) {
                Iterator<Edge> edgesFromThisSource = graph.adjListArr[i].listIterator();
                while (edgesFromThisSource.hasNext()) {
                    Edge edge = edgesFromThisSource.next();

                    int source = edge.source;
                    int destination = edge.destination;
                    int weight = edge.weight;

                    double newDist = dist[source] + weight;

                    if (newDist < dist[destination])
                        dist[destination] = Double.NEGATIVE_INFINITY;
                }
            }

        }
        return dist;
    }

    public static void main(String[] args) {
        int start = 0;

        Graph graph = new Graph(9);
        addEdge(graph, 0, 1, 1);

        addEdge(graph, 1, 2, 1);
        addEdge(graph, 1, 5, 4);
        addEdge(graph, 1, 6, 4);

        addEdge(graph, 2, 4, 1);

        addEdge(graph, 3, 2, 1);
        addEdge(graph, 4, 3, -3);

        addEdge(graph, 5, 7, 3);
        addEdge(graph, 5, 6, 5);

        addEdge(graph, 6, 7, 4);


        double[] doubles = bellmanFord(graph, start);
        System.out.println(Arrays.toString(doubles));
    }
}
