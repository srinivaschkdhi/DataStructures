package graphs;

import java.util.*;

public class ShortestPathBreadthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge( 0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge( 3, 7);
        graph.addEdge(4, 5);
        graph.addEdge( 4, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        int source = 2, dest = 6;
        shortestPath(graph,source,dest);
    }

    static void shortestPath(Graph graph,int src,int dest) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> reversePath = new ArrayList<>();
        int v = graph.V;
        boolean[] visited = new boolean[v];
        int[] dist = new int[v];
        int[] pred = new int[v];

        Arrays.fill(pred,-1);
        Arrays.fill(dist,-1);

        visited[src] = true;
        dist[src] = 0;

        queue.add(src);
        while (!queue.isEmpty()) {
            int s = queue.poll();

            Iterator<Integer> i = graph.adjListArray[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (visited[n] == false) {
                    visited[n] = true;
                    queue.add(n);

                    //modified breadth first search
                    dist[n] = dist[s] + 1;
                    pred[n] = s;
                    if (n == dest){
                        printShortestPath(src, dest, reversePath, dist[n], pred);
                        return;
                    }
                }
            }
        }
        throw new RuntimeException("Path does not exist");

    }

    private static void printShortestPath(int src, int dest, ArrayList<Integer> reversePath, int distance, int[] pred) {
        System.out.println("Shortest path between source and dest is "+ distance);
        int arrayIdx = dest;
        for (int j = 0; j < distance -1 ; j++) {// since 2 and 6 excluding
            int vertex = pred[arrayIdx];
            reversePath.add(vertex);
            arrayIdx = vertex;
        }
        Collections.reverse(reversePath);
        System.out.print("path is :");
        System.out.print(src+"->");
        reversePath.forEach((vertex)->System.out.print(vertex+"->"));
        System.out.println(dest);
    }
}
