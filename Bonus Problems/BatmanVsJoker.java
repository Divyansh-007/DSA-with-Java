import java.util.*;

public class Solution {

    public static void main(String args[]) {
        //Write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] towers = new long[n];
        
        for(int i = 0; i < n; i++){
            towers[i] = s.nextInt();
        }
        
        long sum = 0;
        
        for(int i = 0; i < n; i++){
            long curr = towers[i];
            for(int j = i + 1; j < n; j++){
                if(towers[j] > curr){
                    sum = sum + towers[j];
                    break;
                }
            }
        }
        
        System.out.println(sum % 1000000007);


    }

}
