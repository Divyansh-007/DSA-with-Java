import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // to return path from S to D (DF way) helper
    public static ArrayList<Integer> getPathDFS(int[][] adjMatrix, int S, int D, boolean[] visited){
        if(S == D) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(S);

            return ans;
        }

        visited[S] = true;
		for(int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[S][i] == 1 && visited[i] == false) {
				visited[i] = true;
				ArrayList<Integer> remainingPath = getPathDFS(adjMatrix, i, D, visited);

				if(remainingPath == null) {
					continue;
				}else {
					remainingPath.add(S);
					return remainingPath;
				}
			}
        }

        return null;
    }

    // to return path from S to D (DF way) main
    public static ArrayList<Integer> getPathDFS(int[][] adjMatrix, int S, int D){
        boolean[] visited = new boolean[adjMatrix.length];
        return getPathDFS(adjMatrix, S, D, visited);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        Scanner s = new Scanner(System.in);
        int n  = s.nextInt();
        int e = s.nextInt();
        int[][] adjMatrix = new int[n][n];

        for(int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        int S = s.nextInt();
        int D = s.nextInt();

        ArrayList<Integer> path = getPathDFS(adjMatrix, S, D);

        if(path == null) {
            return;
        }else {
            for(int elem : path) {
                System.out.print(elem + " ");
            }
        }
    }
}
