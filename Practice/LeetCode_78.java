class Solution {
    
    public List<List<Integer>> subsets(int[] nums,int si) {
        if(si == nums.length){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        
        List<List<Integer>> temp = subsets(nums,si + 1);
        List<List<Integer>> output = new ArrayList<>();
        
        for(int i = 0; i < temp.size(); i++){
            output.add(temp.get(i));
        }
        
        for(int i = 0; i < temp.size(); i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(nums[si]);
            for(int j = 0; j < temp.get(i).size(); j++){
                curr.add(temp.get(i).get(j));
            }
            
            output.add(curr);
        }
        
        return output;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums,0);
    }
}
