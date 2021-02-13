import java.util.Scanner;

public class Solution {

    public static int findMinVer(boolean[] visited, int[] weight) {
		
		int minVer = -1;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == false && (minVer == -1 || weight[i] < weight[minVer])) {
				minVer = i;
			}
		}
		
		return minVer;
	}
	
	public static void primsAlgo(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];
		int[] parent = new int[adjMatrix.length];
		int[] weight = new int[adjMatrix.length];
		
		parent[0] = -1;
		for(int i = 1; i < weight.length; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < adjMatrix.length; i++) {
			int minVer = findMinVer(visited,weight);
            visited[minVer] = true;
			for(int j = 0; j < adjMatrix.length; j++) {
				if(adjMatrix[minVer][j] != 0 && visited[j] == false) {
					if(weight[j] > adjMatrix[minVer][j]) {
						weight[j] = adjMatrix[minVer][j];
						parent[j] = minVer;
					}
				}
			}
		}
		
		for(int i = 1; i < adjMatrix.length; i++) {
			if(i < parent[i]) {
				System.out.println(i + " " + parent[i] + " " + weight[i]);
			}else {
				System.out.println(parent[i] + " " + i + " " +  weight[i]);
			}
		}
	}
    
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        int[][] adjMatrix = new int[V][V];
		
		for(int i = 0; i < E; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int w = s.nextInt();
			adjMatrix[v1][v2] = w;
			adjMatrix[v2][v1] = w;
		}
		
		primsAlgo(adjMatrix);
	}
}
