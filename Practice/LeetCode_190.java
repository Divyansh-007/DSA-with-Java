public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for(int i = 0, j = 31; i < j; i++, j--){
            int t = n;
			
            if(((t >> i) & 1) != ((t >> j) & 1)){
                int mask = (1<<j) + (1<<i);
                 n = n^mask;
            }
        } 
        
        return n;
    }
}
