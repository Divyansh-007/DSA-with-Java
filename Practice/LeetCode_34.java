class Solution {
    
    public int firstIndex(int[] arr, int si, int target){
        if(si == arr.length){
            return -1;
        }
        
        if(arr[si] == target){
            return si;
        }
        
        return firstIndex(arr,si + 1,target);
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            int[] ans = new int[2];
            Arrays.fill(ans,-1);
            return ans;
        }
        
        int fi = firstIndex(nums,0,target);
        
        if(fi == -1){
            int[] ans = new int[2];
            Arrays.fill(ans,-1);
            return ans;
        }
        
        int[] ans = new int[2];
        ans[0] = fi;
        
        int i = fi + 1;
        for(; i < nums.length; i++){
            if(nums[i] != target){
                break;
            }    
        }
        
        ans[1] = i - 1;
        
        return ans;
    }
}
