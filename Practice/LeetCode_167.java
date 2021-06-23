class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans[] = new int[2];
        
        int si = 0;
        int ei = numbers.length - 1;
        
        while(si < ei){
            if(numbers[si] + numbers[ei] == target){
                ans[0] = si + 1;
                ans[1] = ei + 1;
                break;
            }else if(numbers[si] + numbers[ei] > target){
                ei--;
            }else{
                si++;
            }
        }
        
        return ans;
    }
}
