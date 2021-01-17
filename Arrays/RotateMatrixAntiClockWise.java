public class Solution{

    public static void rotate(int input[][]){
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
	 	 * Taking input and printing output is handled automatically.
		*/
        int m = input.length;
        int n;
        if(m<=0) {
            return;
        }else {
            n = input[0].length;
        }

        for(int i=0;i<m;i++) {
            for(int j=i;j<n;j++) {
                int temp = input[j][i]; 
                input[j][i] = input[i][j]; 
                input[i][j] = temp;
            }
        }

        for (int i=0;i<n;i++) 
            for (int j=0,k=input[0].length-1;j<k;j++,k--) { 
                int temp = input[j][i]; 
                input[j][i] = input[k][i]; 
                input[k][i] = temp; 
            } 

    }
}
