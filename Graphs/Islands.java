public class Solution {

    // DF traversal help for checking connection
	public static void dfTraversalHelpForConn(int[][] adjMatrix,int currVertex, boolean[] visited) {
		visited[currVertex] = true;

		for(int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[currVertex][i] == 1 && visited[i] == false) {
				dfTraversalHelpForConn(adjMatrix, i, visited);
			}
		}
	}
    
    

    
	public static int numConnected(int[][] edges, int n) {
        
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        boolean[] visited = new boolean[n];
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			if(visited[i] == false) {
				dfTraversalHelpForConn(edges, i, visited);
				count++;
			}
		}
		
		return count;
	}


}
