class Solution {
    int[][] dp;
    
    public int helper(int r,int c,List<List<Integer>> triangle)
    {
        if(r == triangle.size()){
            return 0;
        }
        
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        
        dp[r][c] = triangle.get(r).get(c)  + Math.min(helper(r+1,c,triangle),helper(r+1,c+1,triangle));
        
        return dp[r][c];
    }

    
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.size()];
        return helper(0,0,triangle);
    }
}
