package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSGraph {

    private int V;
    LinkedList<Integer>[] adjListArray;

    DFSGraph(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }


    void addEdge(int src, int dest) {
        adjListArray[src].add(dest);
    }

    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.dfs(2);
    }

    private void dfs(int v) {
        boolean[] visited = new boolean[V];
        dfs(2, visited);
        dfsIterative(2);
    }

    private void dfs(int i, boolean[] visited) {
        visited[i] = true;
        System.out.println("i = " + i);
        Iterator<Integer> neighs = adjListArray[i].listIterator();
        while (neighs.hasNext()) {
            int neigh = neighs.next();
            if (visited[neigh] == false) {
                dfs(neigh, visited);
            }
        }
    }

    private void dfsIterative(int i) {
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        visited[i] = true;

        while (!stack.isEmpty()) {
            i = stack.pop();
            System.out.println(i);

            Iterator<Integer> neighs = adjListArray[i].listIterator();
            while (neighs.hasNext()) {
                int v = neighs.next();
                if (visited[v] == false) {
                    stack.push(v);
                    visited[v] = true;
                }
            }
        }
    }
}
