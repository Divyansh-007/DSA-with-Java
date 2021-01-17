
public class Solution{  
    
    public static int duplicateNumber(int arr[]) {
    	//Your code goes here
        int ans = 0;
		int[] count = new int[arr.length-1];
		for(int i=0;i<arr.length;i++) {
			count[arr[i]] = count[arr[i]]+1;
		}
		for(int j=0;j<count.length;j++) {
			if(count[j]==2) {
				ans = j;
			}
		}
		return ans;

    }
}