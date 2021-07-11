class Solution {
    public void permuteHelp(int[] arr, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == arr.length)
        {
            res.add(new ArrayList(curr));
            return ;
        }
        else
        {
            for(int i = 0; i < arr.length; i++)
            {
                if(curr.contains(arr[i])){
                    continue;   
                }
                
                curr.add(arr[i]);
                permuteHelp(arr,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        permuteHelp(nums,curr,ans);
        
        return ans;
    }
}
