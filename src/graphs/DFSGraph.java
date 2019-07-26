package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {

        private int V;
        LinkedList<Integer>[] adjListArray;
        DFSGraph(int V){
            this.V = V;
            adjListArray = new LinkedList[V];

            for(int i = 0;i<V;i++){
                adjListArray[i] = new LinkedList<>();
            }
        }


     void addEdge(int src,int dest){
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
        dfs(2,visited);
    }

    private void dfs(int i,boolean[] visited) {
        visited[i] = true;
        System.out.println("i = " + i);
        Iterator<Integer> neighs = adjListArray[i].listIterator();
        while(neighs.hasNext()){
            int neigh = neighs.next();
            if(visited[neigh] == false){
                visited[neigh] = true;
                dfs(neigh,visited);
            }
        }
    }


}
