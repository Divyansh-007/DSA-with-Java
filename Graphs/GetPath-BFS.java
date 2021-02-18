import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class Solution {

    // to return path from S to D (BF way) main
    public static ArrayList<Integer> getPathBFS(int[][] adjMatrix, int S, int D){
        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean pathFound = false;

        q.add(S);
        map.put(S, -1);
        visited[S] = true;

        while(!q.isEmpty()) {
            int front = q.poll();
            for(int i = 0; i < adjMatrix.length; i++) {
                if(adjMatrix[front][i] == 1 && visited[i] == false) {
                    q.add(i);
                    map.put(i, front);
                    visited[i] = true;
                    if(i == D) {
                        pathFound = true;
                        break;
                    }
                }
            }
        }

        if(pathFound) {
            ArrayList<Integer> ans = new ArrayList<>();
            int curr = D;
            while(curr != -1) {
                ans.add(curr);
                int parent = map.get(curr);
                curr = parent;
            }

            return ans;
        }else {
            return null;
        }
    }

    public static void main(String[] args)  throws NumberFormatException, IOException{
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

        ArrayList<Integer> path = getPathBFS(adjMatrix, S, D);

        if(path == null) {
            return;
        }else {
            for(int elem : path) {
                System.out.print(elem + " ");
            }
        }

    }
}
