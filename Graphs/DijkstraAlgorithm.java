import java.util.Scanner;

public class Solution {

	public static int findMinVer(boolean[] visited, int[] distance) {

		int minVer = -1;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == false && (minVer == -1 || distance[i] < distance[minVer])) {
				minVer = i;
			}
		}

		return minVer;
	}

	public static void dijkstraAlgo(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];
		int[] distance = new int[adjMatrix.length];

		distance[0] = 0;
		for(int i = 1; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		for(int i = 0; i < adjMatrix.length; i++) {
			int minVer = findMinVer(visited,distance); 
			visited[minVer] = true;
			for(int j = 0; j < adjMatrix.length; j++) { 
				if(adjMatrix[minVer][j] > 0 && visited[j] == false && adjMatrix[minVer][j] < Integer.MAX_VALUE) {
					if(distance[j] > distance[minVer] + adjMatrix[minVer][j]) {
						distance[j] = distance[minVer] + adjMatrix[minVer][j];
					}
				}
			}
		}

		for(int i = 0; i < adjMatrix.length; i++) {
			System.out.println(i + " " + distance[i]);
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

		dijkstraAlgo(adjMatrix);
	}
}