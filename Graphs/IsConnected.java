import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

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

	// to check if the graph is connected or not
	public static boolean isConnected(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];

		dfTraversalHelpForConn(adjMatrix, 0, visited);
		
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == false) {
				return false;
			}
		}
		
		return true;
	}

    
	public static void main(String[] args) throws NumberFormatException, IOException {
       
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        
    Scanner s = new Scanner(System.in);
		int n  = s.nextInt();
		int e = s.nextInt();
        
    if(n == 0 && e == 0){
       System.out.println(true);
       return;
    }
        
		int[][] adjMatrix = new int[n][n];

		for(int i = 0; i < e; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
        
        System.out.println(isConnected(adjMatrix));

	}

}
