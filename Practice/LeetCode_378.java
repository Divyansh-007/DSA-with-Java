class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] ans = new int[matrix.length * matrix[0].length];
        int m = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                ans[m] = matrix[i][j];
                m++;
            }
        }
        
        Arrays.sort(ans);
        return ans[k - 1];
    }
}
