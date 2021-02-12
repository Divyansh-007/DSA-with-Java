public class Solution {

    public static int numberOfWays(int[] input, int sum, int n, int cs) {
        //Your Code goes here
        if(n>=input.length){
            if(cs==sum){
                return 1;
            }else{
                return 0;
            }
        }
        int exlCase = numberOfWays(input, sum, n +1,cs);

        int incCase = numberOfWays(input, sum , n+1,cs + input[n]) + numberOfWays(input, sum , n+1, cs - input[n]);

        return exlCase + incCase;
    }

    public static int numberOfWays(int[] input, int sum) {
        //Your Code goes here
    int ps = numberOfWays(input, sum,0,0);
        if(sum==0){
            return ps-1;
        }else{
            return ps;
        }
    }
}
