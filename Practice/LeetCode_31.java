public class Solution {
    
    public void swap(int[] arr, int si, int ei) {
        int temp = arr[ei];
        arr[ei] = arr[si];
        arr[si] = temp;
    }
    
    public void reverse(int[] arr, int si) {
        int i = si;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1);
    }
}
