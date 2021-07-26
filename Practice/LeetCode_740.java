class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        
        for(int elem: nums){
            freq[elem]++;
        }
        
        int avoid = 0;
        int using = 0;
        int prev = -1;
        
        for(int i = 0; i <= 10000; i++){
            if(freq[i] > 0){
                int max = Math.max(avoid,using);
                if(i - 1 != prev){
                    using = i * freq[i] + max;
                    avoid = max;
                }else{
                    using = i * freq[i] + avoid;
                    avoid = max;
                }
                
                prev = i;
            }
        }
        
        return Math.max(avoid,using);
    }
}
