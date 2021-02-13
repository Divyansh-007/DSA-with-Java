import java.util.Scanner;

public class Main {

		public static int[][] teamSelectHelp(int[] arr, int n, int si){
		if(n <= 0 || si == arr.length) {
			return new int[1][0];
		}
		
		if(arr.length - si == n) {
			int[][] output = new int[1][arr.length - si];
			for(int i = si; i < arr.length; i++) {
				output[0][i - si] = arr[i];
			}
			
			return output;
		}
		
		int[][] temp1 = teamSelectHelp(arr, n - 1, si + 1);
		int[][] temp2 = teamSelectHelp(arr, n, si + 1);
		
		int[][] output = new int[temp1.length + temp2.length][];
		int index = 0;
		
		for(int i = 0; i < temp1.length; i++) {
			output[index] = new int[temp1[i].length + 1];
			output[index][0] = arr[si];
			for(int j = 0; j < temp1[i].length; j++) {
				output[index][j + 1] = temp1[i][j];
			}
			index = index + 1;
		}
		
		for(int i = 0; i < temp2.length; i++) {
			output[index] = new int[temp2[i].length];
			for(int j = 0; j < temp2[i].length; j++) {
				output[index][j] = temp2[i][j];
			}
			index = index + 1;
		}
		
		return output;
	}
	
	public static int[][] teamSelect(int[] arr, int n){
		return teamSelectHelp(arr,n,0);
	}
    
    
	public static void main(String[] args) {
		// Write your code here
        int n = 12;
		
		Scanner s = new Scanner(System.in);
		int[] arr = new int[s.nextInt()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		
		int[][] teams = teamSelect(arr,n);
		
		for(int i = 0; i < teams.length; i++) {
			for(int j = 0; j < teams[0].length; j++) {
				System.out.print(teams[i][j] + " ");
			}
			System.out.println();
		}

	}

}
