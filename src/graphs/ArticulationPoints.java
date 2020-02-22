/**
 * @author Srinivas_Chintakindhi
 */

package graphs;

import java.util.LinkedList;
import java.util.ListIterator;

public class ArticulationPoints {

    static class Graph {
        int v;
        LinkedList<Integer>[] adjListArr;

        Graph(int v) {
            this.v = v;
            adjListArr = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adjListArr[i] = new LinkedList<>();
            }
        }
    }

    public static void addEdge(Graph graph, int source, int destination) {
        graph.adjListArr[source].add(destination);
        graph.adjListArr[destination].add(source);
    }

    private int id;
    private int[] low, ids;
    private boolean[] visited;
    private boolean[] isArticulationPoint;
    private int rootNodeOutcomingEdgeCount;

    public boolean[] findArticulationPoints(Graph graph) {
        id = 0;
        low = new int[graph.v];
        ids = new int[graph.v];
        visited = new boolean[graph.v];
        isArticulationPoint = new boolean[graph.v];


        for (int i = 0; i < graph.v; i++) {
            if (!visited[i]) {
                dfs(graph, i, i, -1);
                rootNodeOutcomingEdgeCount = 0;
                isArticulationPoint[i] = (rootNodeOutcomingEdgeCount > 1);
            }
        }

        return isArticulationPoint;
    }

    private void dfs(Graph graph, int root, int at, int parent) {

        if (parent == root)
            rootNodeOutcomingEdgeCount++;

        visited[at] = true;
        low[at] = ids[at] = ++id;

        ListIterator<Integer> neigs = graph.adjListArr[at].listIterator();
        while (neigs.hasNext()) {
            int to = neigs.next();
            if (to == parent) continue;

            if (!visited[to]) {
                dfs(graph, root, to, at);

                low[at] = Math.min(low[at], low[to]);

                if (ids[at] <= low[to]) {
                    isArticulationPoint[at] = true;
                }

            } else {
                low[at] = Math.min(low[at], ids[to]);
            }
        }

    }


    public static void main(String[] args) {
        Graph graph = new Graph(9);

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 2, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 6, 7);
        addEdge(graph, 7, 8);
        addEdge(graph, 8, 5);

        boolean[] articulationPoints = new ArticulationPoints().findArticulationPoints(graph);

        for (int i = 0; i < articulationPoints.length; i++)
            if (articulationPoints[i]) System.out.printf("Node %d is an articulation\n", i);
    }
}
