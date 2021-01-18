
public class Solution {  

    public static int[] merge(int arr1[], int arr2[]) {
    	//Your code goes here
        int m = arr1.length;
		int n = arr2.length;
		int[] ans = new int[m+n];
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i<m && j<n) {
			if(arr1[i]<=arr2[j]) {
				ans[k] = arr1[i];
				i = i+1;
				k = k+1;
			}else {
				ans[k] = arr2[j];
				j = j+1;
				k = k+1;
			}
		}
		
		while(i<m) {
			ans[k] = arr1[i];
			i = i+1;
			k = k+1;
		}
		
		while(j<n) {
			ans[k] = arr2[j];
			j = j+1;
			k = k+1;
		}

		return ans;

    }

}
