class Solution {
    public int search(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        
        for(int elem : nums){
            map.put(elem,i);
            i++;
        }
        
        Set<Integer> keys = map.keySet();
        
        if(map.containsKey(target)){
            return map.get(target);
        }else{
            return -1;
        }
    }
}
