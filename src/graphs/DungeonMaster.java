package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DungeonMaster {
    public static void main(String[] args) {
        String[][] m = {
                {"S", ".", "."},
                {"#", "E`", "#"},
                {"#", "#", "#"},
                {"#", "#", "#"}
        };
        int solve = solve(m);
        System.out.println("solve = " + solve);
    }

    public static int solve(String[][] m) {
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();

        boolean[][] visited = new boolean[m.length][m[0].length];
        int sr = 0;
        int sc = 0;
        int numOfNodesInCurrLayer = 1;
        int numOfNodesInNextLayer = 0;
        int moveCount = 0;
        boolean reachEnd = false;

        visited[sr][sc] = true;
        rowQueue.add(sr);
        columnQueue.add(sc);

        while (!rowQueue.isEmpty()) {
            sr = rowQueue.poll();
            sc = columnQueue.poll();

            if (m[sr][sc].equals("E")) {
                reachEnd = true;
                break;
            }

            numOfNodesInNextLayer = explore_neighbours(m, sr, sc, visited, rowQueue, columnQueue, numOfNodesInNextLayer);
            numOfNodesInCurrLayer--;

            if (numOfNodesInCurrLayer == 0) {
                numOfNodesInCurrLayer = numOfNodesInNextLayer;
                numOfNodesInNextLayer = 0;
                moveCount++;
            }
        }
        if (reachEnd)
            return moveCount;
        return -1;
    }

    private static int explore_neighbours(String[][] m, int sr, int sc, boolean[][] visited, Queue<Integer> rowQueue, Queue<Integer> columnQueue, int numOfNodesInNextLayer) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int r = sr + dr[i];
            int c = sc + dc[i];

            if (r < 0 || c < 0)
                continue;
            if (r >= m.length || c >= m[0].length)
                continue;

            if (visited[r][c] == true)
                continue;
            if (m[r][c] == "#")
                continue;

            rowQueue.add(r);
            columnQueue.add(c);
            visited[r][c] = true;

            numOfNodesInNextLayer++;
        }

        return numOfNodesInNextLayer;
    }
}
