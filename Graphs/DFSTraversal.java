import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
  
  public static void dfTraversal(int[][] adjMatrix,int currVertex, boolean[] visited) {
		visited[currVertex] = true;
		System.out.print(currVertex + " ");

		for(int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[currVertex][i] == 1 && visited[i] == false) {
				dfTraversal(adjMatrix, i, visited);
			}
		}
	}
  
  public static void dfTraversal(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];
    
		for(int i = 0; i < adjMatrix.length; i++) {
			if(visited[i] == false) {
				dfTraversal(adjMatrix, i, visited);
				System.out.println();
			}
		}
	}  
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
    Scanner s = new Scanner(System.in);
		int n  = s.nextInt();
		int e = s.nextInt();
        
        if(n == 0){
            return;
        }
        
        if(e == 0){
            for(int i = 0; i < n; i++){
                System.out.print(i + " ");
            }
            return;
        }
        
		int[][] adjMatrix = new int[n][n];
		
		for(int i = 0; i < e; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
        
        dfTraversal(adjMatrix);
	}

}
