class Solution {
    
    int count;
    
    public boolean isSafe(int[][] board, int r, int c, int n){
        int i,j;
        
        for(i = 0; i < r; i++){
            if(board[i][c] == 1){
                return false;
            }
        }
        
        // upper left diagonal
        for(i = r, j = c; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        
        // upper right diagonal
        for(i = r, j = c; i >= 0 && j < n; i--,j++){
            if(board[i][j] == 1){
                return false;
            }
        }
        
        return true;
    }
    
    public void placeQueen(int[][] board, int n, int r){
        if(r == n){
            count++;
            return;
        }
        
        for(int j = 0; j < n; j++){
            if(isSafe(board,r,j,n)){
                board[r][j] = 1;
                placeQueen(board,n, r + 1);
                board[r][j] = 0;
            }
        }
    }
    
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        
        count = 0;
        placeQueen(board,n,0);
        
        // System.out.print(count);
        return count;
    }
}
