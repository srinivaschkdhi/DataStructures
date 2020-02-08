package graphs;

import java.util.*;

public class Dijkstra {
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


    static class Node {
        int start;
        int bestDist;

        Node(int start, int bestDist) {
            this.start = start;
            this.bestDist = bestDist;
        }
    }


    public static void addEdge(Graph graph, int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        graph.adjListArr[source].add(edge);
    }

    public static int dijkstra(Graph graph, int start, int end) {
        int dist[] = new int[graph.v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        Comparator<Node> comparator = Comparator.comparing((node -> node.bestDist));
        PriorityQueue<Node> nodes = new PriorityQueue<>(comparator);
        nodes.add(new Node(start, 0));

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();

            int currNode = node.start;
            ListIterator<Edge> neighs = graph.adjListArr[currNode].listIterator();

            while (neighs.hasNext()) {

                Edge edge = neighs.next();

                int source = edge.source;
                int destinaton = edge.destination;
                int weight = edge.weight;

                int newDist = dist[source] + weight;

                if (dist[destinaton] == Integer.MAX_VALUE) {
                    dist[destinaton] = newDist;
                    nodes.add(new Node(destinaton, newDist));
                } else {
                    if (newDist < dist[destinaton]) {
                        dist[destinaton] = newDist;
                        boolean b = nodes.removeIf(nodeInPQ -> nodeInPQ.start == destinaton);
                        System.out.println("b = " + b);
                        nodes.add(new Node(destinaton, newDist));
                    }
                }
            }
        }
        return dist[end];
    }


    public static void main(String[] args) {
        Graph graph = new Graph(8);
        addEdge(graph, 0, 1, 3);
        addEdge(graph, 0, 2, 6);

        addEdge(graph, 1, 2, 4);
        addEdge(graph, 1, 3, 4);
        addEdge(graph, 1, 4, 11);

        addEdge(graph, 2, 3, 8);
        addEdge(graph, 2, 6, 11);

        addEdge(graph,3,4,4);
        addEdge(graph, 3, 5, 5);
        addEdge(graph, 3, 6, 2);

        addEdge(graph, 4, 7, 9);

        addEdge(graph, 5, 7, 1);

        addEdge(graph, 6, 7, 2);

        int shortDis = dijkstra(graph, 1, 7);
        System.out.println("shortDis = " + shortDis);


        Graph graph1 = new Graph(9);
        addEdge(graph1,0,1,4);
        addEdge(graph1,0,7,8);

        addEdge(graph1,1,2,8);
        addEdge(graph1,1,7,11);

        addEdge(graph1,2,5,4);
        addEdge(graph1,2,3,7);
        addEdge(graph1,2,8,2);

        addEdge(graph1,3,4,9);
        addEdge(graph1,3,5,14);

        addEdge(graph1,4,5,10);

        addEdge(graph1,5,6,2);

        addEdge(graph1,6,7,1);
        addEdge(graph1,6,8,6);

        addEdge(graph1,7,8,7);

        int dijkstra = dijkstra(graph1, 2,4);
        System.out.println("shortest path = " + dijkstra);

    }

}
