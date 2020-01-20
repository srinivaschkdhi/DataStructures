package graphs;

import java.util.LinkedList;

class Graph {
    int V;
    LinkedList<Integer>[] adjListArray;

    Graph(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjListArray[src].add(dest);
        adjListArray[dest].add(src);
    }

    void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int x : adjListArray[v]) {
            if (!visited[x]) {
                dfs(x, visited);
            }
        }
    }

    void connectedComponents(){
        boolean[] visited = new boolean[V];

        for (int v = 0; v < V; v++) {
            if(!visited[v]){
                dfs(v,visited);
                System.out.println();
            }
        }
    }

}

public class ConnectedComponents{
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1,0);
        graph.addEdge(2,3);
        graph.addEdge(3,4);

        System.out.println("Following are connected components");
        graph.connectedComponents();
    }
}