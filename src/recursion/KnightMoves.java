/**
 * @author Srinivas_Chintakindhi
 */

package recursion;

public class KnightMoves {
    private static boolean canPlace(int board[][], int n, int r, int c) {
        return
                r >= 0 && r < n &&
                        c >= 0 && c < n &&
                        board[r][c] == 0;
    }

    static boolean solveKnightMove(int[][] board, int n, int move_no, int sr, int sc) {
        if (move_no == n * n)
            return true;

        int[] dr = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < n; i++) {
            int r = sr + dr[i];
            int c = sc + dc[i];

            if (canPlace(board, n, r, c)) {
                board[r][c] = move_no + 1;
                boolean isSuccess = solveKnightMove(board, n, move_no + 1, r, c);

                if (isSuccess == true) return true;
                board[r][c] = 0;
            }
        }
        return false;
    }

    static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + "     ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] board = new int[n][n];
        board[0][0] = 1;

        boolean answer = solveKnightMove(board, n, 1, 0, 0);

        if (answer == true)
            printBoard(board, n);
        else
            System.out.println("Sorry Man! Can't Visit the board");
    }
}
