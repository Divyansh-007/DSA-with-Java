class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = ans.get(i - 1);
            
            curr.add(1);
            
            for(int j = 1; j < i; j++){
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            
            curr.add(1);
            
            ans.add(curr);
        }
        
        return ans;
    }
    
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = generate(rowIndex + 1);
        return triangle.get(rowIndex);
    }
}
