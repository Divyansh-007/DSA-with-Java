
public class Solution {

    public static int firstIndex(int input[], int x) {
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        if(input.length < 1) {
            return -1;
        }

        if(input[0] == x) {
            return 0;
        }

        int[] smallArray = new int[input.length-1];
        for(int i=1;i<input.length;i++) {
            smallArray[i-1] = input[i];
        }

        int smallAnswer = firstIndex(smallArray, x);

        if(smallAnswer == -1) {
            return -1;
        }else {
            return smallAnswer + 1;
        }
    }

}
