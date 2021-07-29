class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;
        
        for(int elem : aliceSizes){
            aliceSum += elem;
        }
        
        for(int elem : bobSizes){
            bobSum += elem;
        }
        
        int delta = (bobSum - aliceSum) / 2;
        
        Set<Integer> bobSet = new HashSet<>();
        
        for(int elem : bobSizes){
            bobSet.add(elem);
        }
        
        for(int elem : aliceSizes){
            if(bobSet.contains(elem + delta)){
                return new int[]{elem , elem + delta};
            }
        }
        
        return null;
    }
}
