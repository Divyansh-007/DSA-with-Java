class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int mat[][] = new int[m][n];
        
        for(int i = 0; i < indices.length; i++){
            int ri = indices[i][0];
            int ci = indices[i][1];
            
            for(int col = 0; col < n; col++){
                mat[ri][col]++;
            }
            
            for(int row = 0; row < m; row++){
                mat[row][ci]++;
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] % 2 != 0){
                    count++;
                }
            }
        }
        
        return count;
    }
}
