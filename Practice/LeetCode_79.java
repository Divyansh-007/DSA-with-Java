class Solution {
    
    public static boolean dfs(char[][] board, int x, int y, int count, String word, int[][] used) {
		if(count == word.length()) {
			return true;
		}
		
		if(x == -1 || x == board.length || y == -1 || y == board[0].length 
		   || board[x][y] != word.charAt(count) || used[x][y] == 1) {
			return false;
		}
		
		used[x][y] = 1;
		boolean found = dfs(board, x - 1, y, count + 1, word, used)
						|| dfs(board, x + 1, y, count + 1, word, used)
						|| dfs(board, x, y - 1, count + 1, word, used)
						|| dfs(board, x, y + 1, count + 1, word, used);
		
		used[x][y] = 0;
		return found;
	}
    
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] used = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == word.charAt(0) && dfs(board,i,j,0,word,used)) {
					return true;
				}
			}
		}
		
		return false;
    }
}
