class Solution {
    int count = 0;
    
    public void helper(int[] arr, int i, int sum, int target){
        if(i == arr.length){
            if(sum == target){
                count++;
            }
        }else{
            helper(arr, i + 1, sum + arr[i], target);
            helper(arr, i + 1, sum - arr[i], target);
        }
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        helper(nums,0,0,target);
        return count;
    }
}
