
public class Solution {


    public static boolean isSafe(int[][] board, int row, int col, int n) {
        int i,j;

        for(i = 0; i < row; i++) {
            if(board[i][col] == 1) {
                return false;
            }
        }

        // upper left diagonal
        for(i = row, j = col; i >= 0 && j >= 0; i--,j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        // upper right diagonal
        for(i = row, j = col; i >= 0 && j < n; i--,j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean placeQueens(int[][] board, int n, int row) {
        if(row == n) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
            return false;
        }

        for(int j = 0; j < n; j++) {
            if(isSafe(board, row, j, n)) {
                board[row][j] = 1;

                if(placeQueens(board, n, row + 1)) {
                    return true;
                }

                board[row][j] = 0;
            }
        }

        return false;
    }
    
    public static void placeNQueens(int n){

        /* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Print output as specified in the question
	 */
        int[][] board = new int[n][n];
		placeQueens(board, n, 0);


    }

}
