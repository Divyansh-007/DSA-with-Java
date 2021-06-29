class Solution {
    
    public boolean isSafe(char[][] board, int r, int c, int n){
        int i,j;
        
        for(i = 0; i < r; i++){
            if(board[i][c] == 'Q'){
                return false;
            }
        }
        
        // upper left diagonal
        for(i = r, j = c; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        // upper right diagonal
        for(i = r, j = c; i >= 0 && j < n; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
    
    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        
        return res;
    }
    
    public void placeQueens(char[][] board, int r, int n, List<List<String>> res){
        if(r == n){
            res.add(construct(board));
            return;
        }
        
        for(int j = 0; j < n; j++){
            if(isSafe(board,r,j,n)){
                board[r][j] = 'Q';
                placeQueens(board,r + 1,n,res);
                board[r][j] = '.';
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        
        List<List<String>> output = new ArrayList<List<String>>();
        placeQueens(board,0,n,output);
        
        return output;
    }
}
