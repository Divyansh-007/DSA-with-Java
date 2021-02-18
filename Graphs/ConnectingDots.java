import java.util.*;

public class Solution {

    public boolean helper(String[] board, int n, int m, int i, int j, int orgi, int orgj, int c, boolean visited[][], char ch){
        if (i == -1 || j == -1 || i >= n || j >= m){
            return false;
        }
        
        if (i == orgi && j == orgj && c >= 4){
            return true;
        }

        if (i == orgi && j == orgj && c < 4 && visited[i][j]){
            return false;
        }

        if (visited[i][j] || board[i].charAt(j) != ch){
            return false;
        }
        
        visited[i][j] = true;
        
        return helper(board,n,m,i-1,j,orgi,orgj,c+1,visited,ch) || helper(board,n,m,i+1,j,orgi,orgj,c+1,visited,ch) 
            || helper(board,n,m,i,j+1,orgi,orgj,c+1,visited,ch) || helper(board,n,m,i,j-1,orgi,orgj,c+1,visited,ch);
    }

    public int solve(String[] board , int n, int m)
    {
        for(int i = 0;i<n;i++){
            for (int j=0;j<m;j++){
                boolean visited[][] = new boolean[n][m];
                int c=0;
                if (helper(board,n,m,i,j,i,j,c,visited,board[i].charAt(j))){
                    return 1;
                }
            }
        }
        return 0;
    }

}
