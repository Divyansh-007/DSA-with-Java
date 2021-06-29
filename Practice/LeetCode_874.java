class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int j = 0;
        int ans = 0;
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        
        Set<String> obst = new HashSet<>();
        
        for(int[] obs : obstacles){
            obst.add(obs[0] + " " + obs[1]);
        }
        
        for(int i = 0; i < commands.length; i++){
            if(commands[i] == -1){
                j = (j + 1) % 4;
            }else if(commands[i] == -2){
                j = (j + 3) % 4;
            }else{
                while(commands[i] > 0 && !obst.contains((x + d[j][0]) + " " + (y + d[j][1]))){
                    x = x + d[j][0];
                    y = y + d[j][1];
                    commands[i]--;
                }   
            }
            
            ans = Math.max(ans, (x * x + y * y));
        }
        
        return ans;
    }
}
