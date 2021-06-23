class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int copy[] = new int[n];
        
        for(int i = 0 ; i < arr.length; i++){
            copy[i] = arr[i];
        }
        
        Arrays.sort(copy);
        int rank = 1;
        
        for(int i = 0; i < copy.length; i++){
            if(map.containsKey(copy[i])){
                continue;
            }
            
            map.put(copy[i],rank);
            rank++;
        }
        
        int ans[] = new int[n];
        
        for(int i = 0; i < arr.length; i++){
            ans[i] = map.get(arr[i]);
        }
        
        return ans;
    }
}
