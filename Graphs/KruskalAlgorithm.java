import java.util.Scanner;
import java.util.Arrays;

class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int w;
	
	public Edge(int v1, int v2, int w) {
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}

	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}

public class Solution {

    public static int findParent(int v, int[] parent) {
		if(v == parent[v]) {
			return v;
		}
		
		return findParent(parent[v], parent);
	}
	
	public static Edge[] kruskalAlgo(Edge[] edges, int n) {
		Arrays.sort(edges);
		Edge[] mst = new Edge[n - 1];
		int[] parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		int i = 0;
		while(count != n - 1) {
			Edge curr = edges[i++];
			int v1P = findParent(curr.v1, parent);
			int v2P = findParent(curr.v2, parent);
			
			if(v1P != v2P) {
				mst[count] = curr;
				count++;
				parent[v1P] = v2P;
			}
		}
		
		return mst;
	}
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        Edge[] edges = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			Edge edg = new Edge(v1, v2, weight);
			edges[i] = edg;
		}
		
		Edge[] mst = kruskalAlgo(edges,V);
		
		for(int i = 0; i < mst.length; i++) {
			if(mst[i].v1 < mst[i].v2) {
				System.out.println(mst[i].v1 + " " + mst[i].v2 + " "  + mst[i].w);
			}else {
				System.out.println(mst[i].v2 + " " + mst[i].v1 + " "  + mst[i].w);
			}
		}
	}
}
