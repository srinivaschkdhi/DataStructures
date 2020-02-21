/**
 * @author Srinivas_Chintakindhi
 */

package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BridgesUnDirectedGraph {

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

    public List<Integer> findBridges(Graph graph) {
        id = 0;
        low = new int[graph.v];
        ids = new int[graph.v];
        visited = new boolean[graph.v];

        List<Integer> bridges = new ArrayList<>();

        for (int i = 0; i < graph.v; i++) {
            if (!visited[i])
                dfs(graph,i, -1, bridges);
        }

        return bridges;
    }

    private void dfs(Graph graph,int at, int parent, List<Integer> bridges) {
        visited[at] = true;
        low[at] = ids[at] = ++id;

        ListIterator<Integer> neigs = graph.adjListArr[at].listIterator();
        while(neigs.hasNext()){
            int neigh = neigs.next();
            if(neigh == parent)continue;

            if(!visited[neigh]){
                dfs(graph,neigh,at,bridges);

                low[at] = Math.min(low[at],low[neigh]);

                if(ids[at] < low[neigh]){
                    bridges.add(at);
                    bridges.add(neigh);
                }
                
            }else{
                low[at] = Math.min(low[at],ids[neigh]);
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

        List<Integer> bridges = new BridgesUnDirectedGraph().findBridges(graph);

        for(int i = 0;i<bridges.size()/2;i++){
            int node1 = bridges.get(2 * i);
            int node2 = bridges.get(2 * i + 1);

            System.out.printf("Bridges between nodes : %d and %d\n",node1,node2);
        }


    }

}
