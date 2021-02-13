
public class Solution {

    public static int sqSumOfDig(int n){
        int sum = 0;

        while(n > 0){
            sum = sum + (int)(Math.pow((n % 10),2));
            n = n / 10;
        }

        return sum;
    }

    public static boolean findHappyNumber(int n) {

        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	* Taking input and printing output is handled automatically.
		*/

        if(n<10) {
            if(n==1||n==7){
                return true;  
            }else{
                return false;
            } 
        }

        int nextNum = sqSumOfDig(n);
        return findHappyNumber(nextNum);
    }
}
