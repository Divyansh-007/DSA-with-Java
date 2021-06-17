class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]) + 1);
                continue;
            }
            
            map.put(arr[i],1);
        }
        
        List<Integer> luckyNums = new ArrayList<>();
        
        Set<Integer> keys = map.keySet();
        
        for(int key : keys){
            if(map.get(key) == key){
                luckyNums.add(key);
            }
        }
        
        if(luckyNums.size() != 0){
            Collections.sort(luckyNums);
            return luckyNums.get(luckyNums.size() - 1);
        }else{
            return -1;
        }
        
    }
}
