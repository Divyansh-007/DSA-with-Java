public class Solution {
	
    public static boolean dfs(String[] Graph, int x, int y, int count, String word, int[][] used) {
		if(count == word.length()) {
			return true;
		}
		
		if(x == -1 || x == Graph.length || y == -1 || y == Graph[0].length() 
		   || Graph[x].charAt(y) != word.charAt(count) || used[x][y] == 1) {
			return false;
		}
		
		used[x][y] = 1;
		boolean found = dfs(Graph, x - 1, y - 1, count + 1, word, used)
						|| dfs(Graph, x - 1, y, count + 1, word, used)
						|| dfs(Graph, x - 1, y + 1, count + 1, word, used)
						|| dfs(Graph, x, y - 1, count + 1, word, used)
						|| dfs(Graph, x, y + 1, count + 1, word, used)
						|| dfs(Graph, x + 1, y - 1, count + 1, word, used)
						|| dfs(Graph, x + 1, y, count + 1, word, used)
						|| dfs(Graph, x + 1, y + 1, count + 1, word, used);
		
		used[x][y] = 0;
		return found;
	}
    
	public static int solve(String[] Graph , int N, int M)
	{
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        String word = "CODINGNINJA";
		int[][] used = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(Graph[i].charAt(j) == word.charAt(0) && dfs(Graph,i,j,0,word,used)) {
					return 1;
				}
			}
		}
		
		return 0;
	}
	
	
}
