import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // to find if path is possible from S to D (DF way) helper
    public static boolean hasPathDFHelp(int[][] adjMatrix, int S, int D, boolean[] visited) {
        if(S == D) {
            return true;
        }

        visited[S] = true;
        for(int i = 0 ; i < adjMatrix.length; i++) {
            if(adjMatrix[S][i] == 1 && visited[i] == false) {
                visited[i] = true;
                return hasPathDFHelp(adjMatrix, i, D, visited);
            }
        }

        return false;
    }

    // to find if path is possible from S to D (DF way) main
    public static boolean hasPathDF(int[][] adjMatrix, int S, int D) {
        boolean[] visited = new boolean[adjMatrix.length];
        return hasPathDFHelp(adjMatrix, S, D, visited);
    }

    // to find if path is possible from S to D (BF way) main
    public static boolean hasPathBF(int[][] adjMatrix, int S, int D) {
        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(S);
        visited[S] = true;

        while(!q.isEmpty()) {
            int front = q.poll();
            for(int i = 0; i < adjMatrix.length; i++) {
                if(adjMatrix[front][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;

                    if(i == D) {
                        return true;
                    }
                }
            }
        }

        return false;
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

        System.out.print(hasPathBF(adjMatrix, S, D));

    }

}
