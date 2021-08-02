class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        
        for (int i = 0; i < moves.length; i++) {
            int player = i % 2 == 0 ? 1 : 2;
            int x = moves[i][0];
            int y = moves[i][1];
            board[x][y] = player;
            
            // check column
            if (board[0][y] == player && board[1][y] == player && board[2][y] == player) {
                return player == 1 ? "A" : "B";
            }
            // check row
            if (board[x][0] == player && board[x][1] == player && board[x][2] == player) {
                return player == 1 ? "A" : "B";
            }
            // check diag
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return player == 1 ? "A" : "B";
            }
            if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
                return player == 1 ? "A" : "B";
            }
        }
        
        return moves.length == 9 ? "Draw" : "Pending";   
    }
}
