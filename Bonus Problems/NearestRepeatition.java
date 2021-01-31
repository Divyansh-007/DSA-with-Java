import java.util.*;

public class Solution{
    
    public static int nextIndex(int[] arr, int val, int si, int ei){
        while(si < ei){
            if(arr[si] == val){
                return si;
            }else if(arr[ei] == val){
                return ei;
            }else{
                si++;
                ei--;
            }
        }
        
        return -1;
    }
	
    public static int minDistance(int[] arr){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++){
        	int repInd =  nextIndex(arr,arr[i],i + 1, arr.length - 1);
            if(repInd != -1){
                int currDis = repInd - i;
                if(currDis < min){
                    min = currDis;
                }
            }
        }
        
        return min;
	}

}
