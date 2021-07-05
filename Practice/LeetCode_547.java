class Solution {
    
    public void dfs(int[][] graph, int currVertex, boolean[] vis){
        vis[currVertex] = true;
        
        for(int i = 0; i < graph[0].length; i++){
            if(graph[currVertex][i] == 1 && vis[i] == false){
                dfs(graph,i,vis);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                dfs(isConnected,i,vis);
                count++;
            }
        }
        
        return count;
    }
}
