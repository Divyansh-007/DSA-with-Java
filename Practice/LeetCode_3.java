class Solution {
    
    public int windowScan(int si, int ei, char[] arr, char c){
        for(int i = si ; i < ei; i++){
            if(arr[i] == c){
                return i;
            }
        }
        
        return -1;
    }
    
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty() || s == null){
            return 0;
        }
        
        int start = 0;
        int end = 0;
        int max  = 0;
        
        char[] arr = s.toCharArray();
        
        while(start < arr.length && end < arr.length){
            int index = windowScan(start,end,arr,arr[end]);
            if(index != -1){
                start = index + 1;
            }
            
            max = Math.max(max, end - start + 1);
            end++;
        }
        
        return max;
    }
}
