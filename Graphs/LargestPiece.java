public class Solution {

    public static int dfsHelper(String[] Graph, int x, int y, boolean[][] visited) {
		if(x == -1 || x == Graph.length || y == -1 || y == Graph[0].length() || visited[x][y] == true || Graph[x].charAt(y) != '1') {
			return 0;
		}
		
		int ans = 0;
		visited[x][y] = true;
		ans = ans + dfsHelper(Graph, x, y - 1, visited) + dfsHelper(Graph, x - 1, y, visited) +
                    dfsHelper(Graph, x, y + 1, visited) + dfsHelper(Graph, x + 1, y, visited);
		
		
		return ans + 1;
	}
    
	public static int dfs(String[] edge, int n) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
    
    boolean[][] visited = new boolean[n][n];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			for(int j= 0; j < n; j++) {
				if(edge[i].charAt(j) == '1' && visited[i][j] == false) {
					int currAns = dfsHelper(edge,i,j,visited);
					if(currAns > max) {
						max = currAns;
					}
				}
			}
		}
		
		return max;
	}
}
