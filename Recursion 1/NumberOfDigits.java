public class Solution {

	public static int sum(int input[]) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        if(input.length==1) {
			return input[input.length-1];
		}
		
		int[] smallArray = new int[input.length-1];
		for(int i=1;i<input.length;i++) {
			smallArray[i-1] = input[i];
		}
		
		int smallSum = sum(smallArray);
		return input[0]+smallSum;
		
		
	}
}