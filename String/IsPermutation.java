public class solution {

	public static boolean isPermutation(String input1, String input2) {
	    // Write your code here
		boolean ans = true;
		int n = input1.length();
		int m = input2.length();

		if(n!=m) {
			ans = false;
		}else {
			int[] freq = new int[256];
			for(int i=0;i<input1.length();i++) {
				freq[input1.charAt(i)] = freq[input1.charAt(i)]+1; 
			}
			
			for(int j=0;j<input2.length();j++) {
				freq[input2.charAt(j)] = freq[input2.charAt(j)]-1;
			}
			
			for(int k=0;k<freq.length;k++) {
				if(freq[k]!=0) {
					ans = false;
					break;
				}
			}
		}
		return ans;
	}
}
