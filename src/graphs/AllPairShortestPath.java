/**
 * @author Srinivas_Chintakindhi
 */

package graphs;

public class AllPairShortestPath {
    final static int INF = 99999, v = 4;

    void floydWarshall(int[][] graph){
        int[][] dist = new int[v][v];
        int i,j,k;

        for(i = 0;i<v;i++){
            for(j = 0;j<v;j++){
                dist[i][j] = graph[i][j];
            }
        }

        for (k = 0;k < v;k++){  //apply on all vertices. check if there is shortest path going through kth vertex.

            for(i = 0;i<v;i++){
                for(j = 0;j<v;j++){
                    if(dist[i][k]+dist[k][j] < dist[i][j])
                        dist[i][j]  = dist[i][k] + dist[k][j];
                }
            }

        }

        printSolution(dist);
    }

    void printSolution(int[][] dist){

        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<v; ++i)
        {
            for (int j=0; j<v; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        AllPairShortestPath a = new AllPairShortestPath();

        // Print the solution
        a.floydWarshall(graph);
    }
}
