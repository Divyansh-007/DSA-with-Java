class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i : nums) {
            if (!list.contains(i)) {
                pq.add(i);
                list.add(i);
                if (pq.size() > 3) {
                    list.remove(pq.poll());
                }
            }
        }
        
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}
